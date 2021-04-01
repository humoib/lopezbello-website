package com.tgd.things.plugins;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Component
public class PhotoServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServicePlugin.class);

	private Resource gcsFile;

	private Resource gcsRoot;

	@Value("${valor}---")
	public String valor;

	@javax.annotation.Resource
	public Environment env;

	public PhotoServicePlugin(Resource gcsRoot, Resource gcsFile) {
		this.gcsRoot = gcsRoot;
		this.gcsFile = gcsFile;

	}

	@Autowired
	public PhotoServicePlugin(@Value("${valor}") String valor) {
		this.valor = valor;
	}

	// @Value("${filesystem.directory}")
	// public void setDirectory(String value) {
	// this.directory = value;
	// }

	/**
	 * 
	 * @return
	 */
	public String getAlbumsHtml() {
		LOGGER.debug("## getAlbumsHtml");

		String result = "";

		LOGGER.debug("HELLO gcsRoot: {}", gcsRoot); // .getProperty("valor")

		try {
			InputStream folder = gcsRoot.getInputStream();

			LOGGER.debug("folder: " + folder.read());

			Storage storage = StorageOptions.newBuilder().setProjectId("personal-1275").build().getService();
			Bucket bucket = storage.get("photo-test-1234");
			Page<Blob> blobs = bucket.list();

			for (Blob blob : blobs.iterateAll()) {
				LOGGER.debug("--> " + blob.getName());
				result += blob.getName();
			}

			PhotoServicePlugin.listObjectsWithPrefix("personal-1275", "photo-test-1234", "");

		} catch (Exception e) {
			LOGGER.error("error " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	String writeGcs(@RequestBody String data) throws IOException {

		try (OutputStream os = ((WritableResource) this.gcsFile).getOutputStream()) {
			os.write(data.getBytes());
		}

		try {
			InputStream folder = gcsRoot.getInputStream();

			LOGGER.debug("folder: " + folder.read());

			Storage storage = StorageOptions.newBuilder().setProjectId("personal-1275").build().getService();
			Bucket bucket = storage.get("photo-test-1234");
			Page<Blob> blobs = bucket.list();

			for (Blob blob : blobs.iterateAll()) {
				System.out.println("--> " + blob.getName());
			}

			listObjectsWithPrefix("personal-1275", "photo-test-1234", "");

		} catch (Exception e) {
			LOGGER.error("error " + e.getMessage());
		}
		;

		return "file was updated2\n";
	}

	public static void listObjectsWithPrefix(String projectId, String bucketName, String directoryPrefix) {
		// The ID of your GCP project
		// String projectId = "your-project-id";

		// The ID of your GCS bucket
		// String bucketName = "your-unique-bucket-name";

		// The directory prefix to search for
		// String directoryPrefix = "myDirectory/"

		Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		Bucket bucket = storage.get(bucketName);
		/**
		 * Using the Storage.BlobListOption.currentDirectory() option here causes the
		 * results to display in a "directory-like" mode, showing what objects are in
		 * the directory you've specified, as well as what other directories exist in
		 * that directory. For example, given these blobs:
		 *
		 * <p>
		 * a/1.txt a/b/2.txt a/b/3.txt
		 *
		 * <p>
		 * If you specify prefix = "a/" and don't use
		 * Storage.BlobListOption.currentDirectory(), you'll get back:
		 *
		 * <p>
		 * a/1.txt a/b/2.txt a/b/3.txt
		 *
		 * <p>
		 * However, if you specify prefix = "a/" and do use
		 * Storage.BlobListOption.currentDirectory(), you'll get back:
		 *
		 * <p>
		 * a/1.txt a/b/
		 *
		 * <p>
		 * Because a/1.txt is the only file in the a/ directory and a/b/ is a directory
		 * inside the /a/ directory.
		 */
		Page<Blob> blobs = bucket.list(Storage.BlobListOption.prefix(directoryPrefix),
				Storage.BlobListOption.currentDirectory());

		for (Blob blob : blobs.iterateAll()) {
			System.out.println(blob.getName());
		}
	}

}

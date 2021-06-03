package nl.hu.ipass.Resources;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

public class Blobtest {
    private final static String ENDPOINT = "https://ipassbrampostema.queue.core.windows.net/";
    private final static String SASTOKEN = "?sv=2020-02-10&ss=bfqt&srt=sco&sp=rwdlacuptfx&se=2022-06-03T23:49:40Z&st=2021-06-03T15:49:40Z&spr=https&sig=tDcbW7RDo5C9iXzVNoAzgk0YvHs%2BZew1ZKNEUFAtyYc%3D";
    private final static String CONTAINER = "dagcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder().endpoint(ENDPOINT).sasToken(SASTOKEN).containerName(CONTAINER).buildClient();
}

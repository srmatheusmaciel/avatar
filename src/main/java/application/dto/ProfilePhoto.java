package application.dto;

import java.util.UUID;

import org.jboss.resteasy.reactive.multipart.FileUpload;

public record ProfilePhoto(FileUpload fileUpload) {
    public static ProfilePhoto create(FileUpload fileUpload) {
        return new ProfilePhoto(fileUpload);
    }

    public domain.models.ProfilePhoto toDomain() {
        return new domain.models.ProfilePhoto(UUID.randomUUID().toString(),
                                              fileUpload().uploadedFile().toAbsolutePath().toString(),
                                              null);
    }
}
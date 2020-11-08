package uhk.fim.toolsrental.services;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uhk.fim.toolsrental.models.Product;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileService {


    public static String saveProductImage(MultipartFile file, Product p) throws IOException {

        if(p.getId() == null)
            throw new IOException("Id produktu je prazdne");

        //název souboru
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //název složky (např: ../product-files/2/)
        String uploadDirectoryPath = "./product-files/"+ p.getId();
        Path uploadPath = Paths.get(uploadDirectoryPath);

        //pokud slozka s id produktu jeste neexistuje, vytvori ji
        if(!Files.exists(uploadPath))
            Files.createDirectory(uploadPath);

        try (InputStream stream = file.getInputStream()){
            //plna cesta k souboru (../product-files/2/obrazek.jpg)
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(stream, filePath, StandardCopyOption.REPLACE_EXISTING);
            String resultPath = filePath.toString();
            return resultPath;
        }
        catch (IOException e){
            throw new IOException("Nelze ulozit soubor: " + fileName);
        }
    }

}

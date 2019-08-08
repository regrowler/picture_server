import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.File;

@Path("/")
public class picgetter {
    static String path="C:\\java_projects\\";
    @Produces({"image/jpeg","image/gif"})
    @GET
    public static Response getPic(@QueryParam("id") String d,@QueryParam("format")String format){
        try {
            StringBuilder stringBuilder=new StringBuilder(path);
            stringBuilder.append(d);
            stringBuilder.append(".");
            stringBuilder.append(format);
            System.err.println(stringBuilder.toString());
            File f = new File(stringBuilder.toString());
            if(f.exists()){
                BufferedImage bi = ImageIO.read(f);
                return Response.ok(bi).build();
            }else {
                return Response.noContent().build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
}

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by lschubert on 11/16/15.
 */
public class BlockInterpreterTwo {
    public static void main(String[] args)throws Exception{
        Path p = Paths.get("genBlock");
        byte[] rawBytes = Files.readAllBytes(p);
        Block b = new Block(decodeFromB64(rawBytes));
        //System.out.println(Arrays.toString(b.getNextValue()));
        BlockMinerTest miner = new BlockMinerTest(b.getNextValue());
    }

    private static byte[] decodeFromB64(byte[] b){
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(b);

    }

}

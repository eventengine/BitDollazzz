import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by lschubert on 11/15/15.
 */
public class BlockInterpreter {
    public static void main(String[] args)throws Exception{

        Path path = Paths.get("genesisBlock.b");
        byte[] genBytes = Files.readAllBytes(path);

        boolean blockStarts = false;
        boolean blockEnds = false;
        boolean endOfData = false;
        boolean foundBeginningOfNextNum = false;
        int indexOfNextNum = 0;

        for (int i =0;i <genBytes.length;i++){
            if(!blockStarts){
                if(genBytes[i] ==0x62 && genBytes[i+1] == 0x3A){
                    System.out.println("Block starts here");
                    blockStarts = true;

                }
            }

            if(!endOfData){
                if(genBytes[i] == 0x3A && genBytes[i+1] == 0x64){
                    endOfData = true;
                }
            }

            if(!foundBeginningOfNextNum){
                if(genBytes[i] ==0x6E && genBytes[i+1] == 0x3A){
                    foundBeginningOfNextNum = true;
                    indexOfNextNum = i+2;
                }
            }

            if(!blockEnds){
                if(genBytes[i] ==0x3A && genBytes[i+1] == 0x62){
                    System.out.println("Block ends here");
                    blockEnds = true;

                }
            }
        }
        byte[] nextNum = Arrays.copyOfRange(genBytes,indexOfNextNum,indexOfNextNum+64);


        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] compare = digest.digest("0".getBytes());
        String compareString = new String(compare);
        if(compareString.getBytes()!= nextNum){
            System.out.println("does not match");
        }else{
            System.out.println("Matches");
        }
//        System.out.println(genBytes.length);
//        String t = new String(genBytes);
//        System.out.println(t);
//        printHex(genBytes);

    }

    public static void printHex(byte[] ba) {
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<ba.length;i++) {
            String hex=Integer.toHexString(0xff & ba[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}

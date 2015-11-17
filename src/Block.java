import java.util.Arrays;

/**
 * Created by lschubert on 11/16/15.
 */
public class Block {
    private byte[] nextValue;
    private byte[] previousValue;
    private byte[] data;

    public Block(byte[] b){
        previousValue = Arrays.copyOfRange(b,0,64);
        nextValue = Arrays.copyOfRange(b,64,128);

    }
    public byte[] getNextValue(){
        return nextValue;
    }

    public byte[] getData(){
        //this method returns the transaction data
        return null;
    }



}

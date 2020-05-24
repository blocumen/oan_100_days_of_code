import java.util.Date;
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String data, String previousHash)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash= calculateHash();

    }
    public String calculateHash()
    {
        String calcultatedHash = StringUtil.applySha256(previousHash+Long.toString(timestamp)+data);
        return calcultatedHash;
    }
    public void mineBlock(int difficulty)
    {
        String target = new String(new char[difficulty]).replace('\0','0');
        System.out.println("target  :"+target);
        System.out.println("hashsubstring :"+hash.substring(0,difficulty));
       /* hash = calculateHash();
        System.out.println("hash :"+hash);
        hash = calculateHash();
        System.out.println("hash1 :"+hash);
        hash = calculateHash();
        System.out.println("hash2 :"+hash);*/
         while(!hash.substring(0,difficulty).equals(target))
        {
            //System.out.println("nonce"+nonce);
          nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined "+hash);
    }
}

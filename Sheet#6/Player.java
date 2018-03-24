
/**
 *
 * @author IT676
 */
public class Player {

    private String name;
    private String[] records;
    private int nOfR;

    public Player(String name) {
        this.name = name;
        records = new String[3];
        nOfR = 0;

    }

    public void addRecord(String r) {

        //if array is full , then remove the oldest one --> index :0
        if (nOfR == records.length) {

            //shift the elements
            for (int i = 0; i < nOfR - 1; i++) {
                records[i] = records[i + 1];
            }

            //decrease records by 1
            nOfR--;
            //store the recived record to index 2 --> nOfR whitch is 2 for now 

            //add the record to the index nOfR and update the counter by increasing 1
            records[nOfR++] = r;
        }//end of if it's true
        else {

            records[nOfR++] = r;
        }
    }

    public String getName() {

        return name;
    }

    public int getNumberOfRecords() {

        return nOfR;
    }

    public String[] getRecords() {

        return records;
    }
}

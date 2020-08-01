
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static android.nfc.NfcAdapter.ACTION_TAG_DISCOVERED;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {


    NfcAdapter nfcAdapter;
    TextView txtta1g;
    public int PDOLlength;
    public ByteArrayOutputStream PDOLcom2 = new ByteArrayOutputStream( );
    public ByteArrayOutputStream AFLCOM = new ByteArrayOutputStream( );
    public ByteArrayOutputStream PDOLcom = new ByteArrayOutputStream( );




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView t1 = (TextView)findViewById(R.id.fab1);
        TextView t6 = (TextView)findViewById(R.id.fab6);
        TextView t3 = (TextView)findViewById(R.id.fab3);
        TextView t4 = (TextView)findViewById(R.id.fab4);
        TextView t5 = (TextView)findViewById(R.id.fab5);


        nfcAdapter = NfcAdapter.getDefaultAdapter(this);




        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter!=null && nfcAdapter.isEnabled()){
            t1.setText("Ready to scan card...");
            t1.setVisibility(View.VISIBLE);

            Toast.makeText(this,"NFCAvailable", Toast.LENGTH_SHORT).show();

        }else{
            t1.setText("NFCnotavailable");
            t1.setVisibility(View.VISIBLE);
            Toast.makeText(this,"NFCnotavailable", Toast.LENGTH_SHORT).show();
        }


    }




    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        enableForegroundDispatchSystem();
    }



    @Override
    protected void onPause() {
        super.onPause();
        disableForegroundDispatchSystem();
    }









    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        IsoDep isoDep = IsoDep.get(tag);


        byte[] AID ={};

        byte a1[]=
                {
            (byte) 0x00, // CLA Class
                    (byte) 0xA4, // INS Instruction
                    (byte) 0x04, // P1  Parameter 1
                    (byte) 0x00, // P2  Parameter 2
                    (byte) 0x07, // Length
                        (byte) 0xA0,  (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03,
                        (byte) 0x10,(byte) 0x10,
                        (byte) 0x00,
        };

        byte a2[]=
                {
                        (byte) 0x00, // CLA Class
                        (byte) 0xA4, // INS Instruction
                        (byte) 0x04, // P1  Parameter 1
                        (byte) 0x00, // P2  Parameter 2
                        (byte) 0x07, // Length
                        (byte) 0xA0,  (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x04,
                        (byte) 0x10,(byte) 0x10,
                        (byte) 0x00,
                };




        byte a3[]=
                {
                        (byte) 0x00, // CLA Class
                        (byte) 0xA4, // INS Instruction
                        (byte) 0x04, // P1  Parameter 1
                        (byte) 0x00, // P2  Parameter 2
                        (byte) 0x07, // Length
                        (byte) 0xA0,  (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03,
                        (byte) 0x10,(byte) 0x10,
                        (byte) 0x00,
                };


        byte a4[]=
                {
                        (byte) 0x00, // CLA Class
                        (byte) 0xA4, // INS Instruction
                        (byte) 0x04, // P1  Parameter 1
                        (byte) 0x00, // P2  Parameter 2
                        (byte) 0x07, // Length
                        (byte) 0xA0,  (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03,
                        (byte) 0x10,(byte) 0x10,
                        (byte) 0x00,
                };




        List <byte[]> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);







        List <String> twocode = new ArrayList<>(Arrays.asList(
                "06",
                "41",
                "43",
                "42",
                "44",
                "45",
                "46",
                "47",
                "48",
                "4D",
                "4F",
                "50",
                "51",
                "53",
                "56",
                "57",
                "58",
                "59",
                "5A",
                "5B",
                "5C",
                "5D",
                "5E",
                "61",
                "63",
                "64",
                "65",
                "66",
                "67",
                "68",
                "6C",
                "6D",
                "6E",
                "70",
                "72",
                "73",
                "77",
                "78",
                "79",
                "7E",
                "80",
                "81",
                "82",
                "83",
                "84",
                "86",
                "87",
                "88",
                "88",
                "89",
                "8A",
                "8C",
                "8D",
                "8E",
                "8F",
                "90",
                "91",
                "92",
                "93",
                "94",
                "95",
                "97",
                "99",
                "9A",
                "9B",
                "9C",
                "9D",
                "A5",
                "C3",
                "C4",
                "C5",
                "C6",
                "C7",
                "C8",
                "C9",
                "CA",
                "CB",
                "CD",
                "CE",
                "CF",
                "D1",
                "D2",
                "D3",
                "D6",
                "D5",
                "D7",
                "D8",
                "DA",
                "D9",
                "DB",
                "DC",
                "DD",
                "C8",
                "C9",
                "CA",
                "CB",
                "CD",
                "CE",
                "CF",
                "D1",
                "D2"
        ));





        PDOLlength=0;
        ByteArrayOutputStream PDOLcom = new ByteArrayOutputStream( );



            for (int i = 0; i < list.size(); i++) {

                PDOLcom2 = new ByteArrayOutputStream( );

            try {
                isoDep.connect();
                byte[] result = isoDep.transceive(list.get(i));
                String str = bytesToHex(result);
                Log.i("first transceive", "result " + str);
                int newresult =str.length();
                if(newresult>4){
                    Log.i("transceive success", "proceed ");
                    String search ="9F38";
                    if ( str.indexOf(search) != -1 ) {
                        Log.i("PDOL EXIST", "Looking up PDOL ");
                        String[] parts = str.split(search);

                        String part2 = parts[1];


                        Log.i("info after PDOL Tag", part2);
                        String s1 = part2.substring(0, 2);
                        Log.i("PDOL length", s1);
                        String s2 = part2.substring(2);

                        BigInteger length1 = (hex2decimal(s1).multiply(new BigInteger("2"))).add(new BigInteger("2"));
                        Log.i("PDOL integer length", (length1).toString());
                        String PDOLtext = part2.substring(2, length1.intValue());
//                        List<byte[]> PDOLcom = new ArrayList<>();

                        final byte[] PDOLSTART = {
                                (byte) 0x80, // CLA Class
                                (byte) 0xA8, // INS Instruction
                                (byte) 0x00, // P1  Parameter 1
                                (byte) 0x00, // P2  Parameter 2

                        };

                        //


                        for (int j = 0; j < length1.intValue(); j++) {


                            int length2 = PDOLtext.length();
                            Log.i("PDOL integer length2", Integer.toString(length2));
                            if (length2 < 4) {
                                break;
                            }else{
                                String sector1 = PDOLtext.substring(0, 2);
                                String sector2 = PDOLtext.substring(2, 4);
                                String sector5 = PDOLtext.substring(0, 4);
                                String sector3 = PDOLtext.substring(4, 6);
                                Log.i("1st sector", sector1);
                                Log.i("2nd sector", sector5);

                                if (twocode.contains(sector1))

                                {
                                    Log.i("1st sector", sector1);
                                    PDOLtext = PDOLtext.substring(4);
                                    int sectorbytelength = hex2decimal(sector2).intValue();


                                    if (sector1.equals("9A")) {


                                        byte add1[] =
                                                {
                                                        (byte) 0x18, (byte) 0x09, (byte) 0x20
                                                };
                                        PDOLlength += 3;

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                    }else{


                                    for (int k = 0; k < sectorbytelength; k++) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x00
                                                };


                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");
                                        PDOLlength += 1;
                                    }
                                }
                                } else {

                                    PDOLtext = PDOLtext.substring(6);
                                    Log.i("1st sector", sector1 + sector2);
                                    if (sector5.equals("9F66")) {







                                        byte add1[] =
                                                {
                                                        (byte) 0xB6, (byte) 0x20, (byte) 0xC0, (byte) 0x00
                                                };
                                        PDOLlength += 4;

                                            PDOLcom2.write(add1);
                                            Log.e("PDOL", "written");

                                    } else if (sector5.equals("5F2A")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x01, (byte) 0x24,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  2;
                                    }else if (sector5.equals("9F1A")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x01, (byte) 0x24,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  2;
                                    }
                                    else if (sector5.equals("9F02")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x00, (byte) 0x00,(byte) 0x00,(byte) 0x01,(byte) 0x00,(byte) 0x00,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  6;
                                    }
                                    else if (sector5.equals("9F03")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x00, (byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  6;
                                    }
                                    else if (sector5.equals("9F37")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x82, (byte) 0x3D,(byte) 0xDE,(byte) 0x7A,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  4;
                                    }
                                    else if (sector5.equals("5F2A")) {
                                        byte add1[] =
                                                {
                                                        (byte) 0x09, (byte) 0x78,

                                                };

                                        PDOLcom2.write(add1);
                                        Log.e("PDOL", "written");

                                        PDOLlength +=  2;
                                    }else{
                                        BigInteger lengths = (hex2decimal(sector3));
                                                int lengthsint = lengths.intValue();
                                        for (int k = 0; k < lengthsint; k++) {
                                            byte add1[] =
                                                    {
                                                            (byte) 0x00
                                                    };

                                            PDOLlength +=  1;
                                            PDOLcom2.write(add1);
                                            Log.e("PDOL", "written");

                                        }


                                    }


                                }



                        }


                        }


                        Log.e("PDOLlength", Integer.toString(PDOLlength));
                        byte PDOLcomall[] = PDOLcom2.toByteArray();
                        String PDOLall = bytesToHex(PDOLcomall);
                        Log.e("PDOL", PDOLall);




                        final byte[] firstblock = {
                                (byte) 0x80, // CLA Class
                                (byte) 0xA8, // INS Instruction
                                (byte) 0x00, // P1  Parameter 1
                                (byte) 0x00, // P2  Parameter 2

                        };


                        final byte[] secondblock ={

                                Byte.parseByte(Integer.toString(PDOLlength+2))};



                        final byte[] thirdblock = {

                                (byte) 0x83,

                        };



                        final byte[] endblock = {

                                (byte) 0x00,
                        };



                        final byte[] fourthblock ={

                                Byte.parseByte(Integer.toString(PDOLlength))};









                        PDOLcom.write(firstblock);
                        PDOLcom.write(secondblock);
                        PDOLcom.write(thirdblock);
                        PDOLcom.write(fourthblock);
                        PDOLcom.write(PDOLcomall);
                        PDOLcom.write(endblock);
                        byte PDOLcomfull[] = PDOLcom.toByteArray();
                        String PDOLmax = bytesToHex(PDOLcomfull);
                        Log.i("PDOL transceive data", "" + PDOLmax);
                        byte[] result2 = isoDep.transceive(PDOLcomfull);
                        String str2 = bytesToHex(result2);
                        Log.i("PDOL transceive", "" + str2);








                        String searchforcard ="5713";
                        if ( str2.indexOf(searchforcard) != -1 ) {
                            Log.i("Lookup cardnum", "");
                            String[] cardno = str2.split(searchforcard);
                            String cardnum1 = cardno[1].substring(0, 4);
                            String cardnum2 = cardno[1].substring(4, 8);
                            String cardnum3 = cardno[1].substring(8, 12);
                            String cardnum4 = cardno[1].substring(12, 16);
                            String expyr = cardno[1].substring(17, 19);
                            String expmth = cardno[1].substring(19, 21);
                            TextView t1 = (TextView)findViewById(R.id.fab1);
                            t1.setVisibility(View.INVISIBLE);
                            TextView t6 = (TextView)findViewById(R.id.fab6);
                            TextView t3 = (TextView)findViewById(R.id.fab3);
                            TextView t4 = (TextView)findViewById(R.id.fab4);
                            TextView t5 = (TextView)findViewById(R.id.fab5);
                            t3.setVisibility(View.VISIBLE);
                            t4.setVisibility(View.VISIBLE);
                            t5.setVisibility(View.VISIBLE);
                            t6.setVisibility(View.VISIBLE);
                            t3.setText("Credit Card number");
                            String cardnumspec = cardnum1 + " " +cardnum2 + " "+cardnum3 + " "+cardnum4;
                            t4.setText(cardnumspec);
                            t5.setText("Expiry Date");
                            t6.setText(expmth+ "/" + expyr);








                        }else{
                            TextView t1 = (TextView)findViewById(R.id.fab1);
                            t1.setVisibility(View.INVISIBLE);

                            TextView t6 = (TextView)findViewById(R.id.fab6);
                            TextView t3 = (TextView)findViewById(R.id.fab3);
                            TextView t4 = (TextView)findViewById(R.id.fab4);
                            TextView t5 = (TextView)findViewById(R.id.fab5);
                            t6.setVisibility(View.INVISIBLE);
                            t5.setVisibility(View.INVISIBLE);
                            t4.setVisibility(View.INVISIBLE);
                            t3.setText("Error reading card");
                            t3.setVisibility(View.VISIBLE);
                        }



                    }else{



                        final byte[] GETAPL = {
                                (byte) 0x80, // CLA Class
                                (byte) 0xA8, // INS Instruction
                                (byte) 0x00, // P1  Parameter 1
                                (byte) 0x00, // P2  Parameter 2
                                (byte) 0x02, // Length
                                (byte) 0x83,
                                (byte) 0x00,
                                (byte) 0x00
                        };


                        byte[] result21 = isoDep.transceive(GETAPL);

                        String str21 = bytesToHex(result21);
                        Log.i("test", "TEST: " + str21);






                        String AFLsec ="94";
                        if ( str21.indexOf(AFLsec) != -1 ) {


                            AFLCOM = new ByteArrayOutputStream( );

                            String[] AFL = str21.split(AFLsec);

                            String AFL1st= AFL[1].substring(2,10);
                            String firstsec= AFL1st.substring(2,4);
                            String secafl = AFL1st.substring(0,2);
                            int secaflint = Integer.parseInt(secafl,16);
                            String secaflbin2 = Integer.toBinaryString(secaflint);
                            String secaflbin3 = "000000" + secaflbin2;


                            String secaflbin = secaflbin3.substring(secaflbin3.length() - 8);
                            Log.i("checkbin", "" + secaflbin);

                            String getsecaflstr2 = secaflbin.substring(0,5);
                            String getsecaflstr = getsecaflstr2+"100";

                            int secafldecimal = Integer.parseInt(getsecaflstr,2);
                            String finalsecafl = Integer.toString(secafldecimal);
                            Log.i("checksecafl", "" + finalsecafl);




                            final byte[] block1 = {
                                (byte) 0x00, // CLA Class
                                (byte) 0xB2, // INS Instruction
                                     };

                            final byte[] block2 = {
                                    Byte.parseByte(firstsec)
                            };


                            final byte[] block3 = {
                                    Byte.parseByte(Integer.toString(secafldecimal))
                            };

                            final byte[] block4 = {
                                    (byte) 0x00

                            };


                            AFLCOM.write(block1);
                            AFLCOM.write(block2);
                            AFLCOM.write(block3);
                            AFLCOM.write(block4);

                            byte AFLCOMfull[] = AFLCOM.toByteArray();
                            String str35 = bytesToHex(AFLCOMfull);

                            byte[] result31 = isoDep.transceive(AFLCOMfull);
                            String str31 = bytesToHex(result31);
                            Log.i("test", "TEST: " + str35);

                            Log.i("test", "TEST: " + str31);










                            String searchforcard ="5713";
                            if ( str31.indexOf(searchforcard) != -1 ) {
                                Log.i("Lookup cardnum", "");
                                String[] cardno = str31.split(searchforcard);
                                String cardnum1 = cardno[1].substring(0, 4);
                                String cardnum2 = cardno[1].substring(4, 8);
                                String cardnum3 = cardno[1].substring(8, 12);
                                String cardnum4 = cardno[1].substring(12, 16);
                                String expyr = cardno[1].substring(17, 19);
                                String expmth = cardno[1].substring(19, 21);
                                TextView t1 = (TextView)findViewById(R.id.fab1);
                                t1.setVisibility(View.INVISIBLE);
                                TextView t6 = (TextView)findViewById(R.id.fab6);
                                TextView t3 = (TextView)findViewById(R.id.fab3);
                                TextView t4 = (TextView)findViewById(R.id.fab4);
                                TextView t5 = (TextView)findViewById(R.id.fab5);
                                t3.setVisibility(View.VISIBLE);
                                t4.setVisibility(View.VISIBLE);
                                t5.setVisibility(View.VISIBLE);
                                t6.setVisibility(View.VISIBLE);
                                t3.setText("Credit Card number");
                                String cardnumspec = cardnum1 + " " +cardnum2 + " "+cardnum3 + " "+cardnum4;
                                t4.setText(cardnumspec);
                                t5.setText("Expiry Date");
                                t6.setText(expmth+ "/" + expyr);








                            }else{
                                TextView t1 = (TextView)findViewById(R.id.fab1);
                                t1.setVisibility(View.INVISIBLE);

                                TextView t6 = (TextView)findViewById(R.id.fab6);
                                TextView t3 = (TextView)findViewById(R.id.fab3);
                                TextView t4 = (TextView)findViewById(R.id.fab4);
                                TextView t5 = (TextView)findViewById(R.id.fab5);
                                t6.setVisibility(View.INVISIBLE);
                                t5.setVisibility(View.INVISIBLE);
                                t4.setVisibility(View.INVISIBLE);
                                t3.setText("Error reading card");
                                t3.setVisibility(View.VISIBLE);
                            }





















                        }else{




                            TextView t1 = (TextView)findViewById(R.id.fab1);
                            t1.setVisibility(View.INVISIBLE);

                            TextView t6 = (TextView)findViewById(R.id.fab6);
                            TextView t3 = (TextView)findViewById(R.id.fab3);
                            TextView t4 = (TextView)findViewById(R.id.fab4);
                            TextView t5 = (TextView)findViewById(R.id.fab5);
                            t6.setVisibility(View.INVISIBLE);
                            t5.setVisibility(View.INVISIBLE);
                            t4.setVisibility(View.INVISIBLE);
                            t3.setText("Error reading card");
                            t3.setVisibility(View.VISIBLE);





                        }




                    }









                    break;


                }

                isoDep.close();
            } catch (IOException e) {
                Log.i("error", e.toString());


                TextView t1 = (TextView)findViewById(R.id.fab1);
                t1.setVisibility(View.INVISIBLE);

                TextView t6 = (TextView)findViewById(R.id.fab6);
                TextView t3 = (TextView)findViewById(R.id.fab3);
                TextView t4 = (TextView)findViewById(R.id.fab4);
                TextView t5 = (TextView)findViewById(R.id.fab5);
                t6.setVisibility(View.INVISIBLE);
                t5.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                t3.setText("Error reading card");
                t3.setVisibility(View.VISIBLE);







                try {
                    isoDep.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }












    }








    public static BigInteger hex2decimal(String s) {
        BigInteger result = new BigInteger(s, 16);
        return result;
    }








    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }







private void enableForegroundDispatchSystem() {

    Intent intent = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

    IntentFilter[] intentFilters = new IntentFilter[]{};

    nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilters, null);
}


private void disableForegroundDispatchSystem() {
        nfcAdapter.disableForegroundDispatch(this);
    }














}
cardreader.java
Displaying cardreader.java.

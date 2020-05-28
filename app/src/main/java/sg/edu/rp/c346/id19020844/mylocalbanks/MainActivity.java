package sg.edu.rp.c346.id19020844.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.dbs);
        tvOCBC = findViewById(R.id.ocbc);
        tvUOB = findViewById(R.id.uob);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.equals(tvDBS) == true) {
            menu.add(1, 0, 0, "Website");
            menu.add(1, 1, 1, "Contact the bank");
        }
        else if(v.equals(tvOCBC) == true) {
            menu.add(2, 2, 0, "Website");
            menu.add(2, 3, 1, "Contact the bank");
        }
        else if(v.equals(tvUOB) == true) {
            menu.add(3, 4, 0, "Website");
            menu.add(3, 5, 1, "Contact the bank");
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 0) { // direct user to DBS website
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == 1) { // direct user to call DBS
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800-111-1111"));
            startActivity(intentCall);
            return true;
        }
        else if(item.getItemId() == 2){ // direct user to OCBC website
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == 3) { // direct user to call OCBC
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800-363-3333"));
            startActivity(intentCall);
            return true;
        }
        else if(item.getItemId() == 4) { // direct user to UOB website
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com.sg"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == 5) {  // direct user to call UOB
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800-222-2121"));
            startActivity(intentCall);
            return true;
        }

        return super.onContextItemSelected(item);
    }

    // Change bank name from ENGLISH to CHINESE
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.eng) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        }
        else if(id == R.id.chi) {
            tvDBS.setText(getString(R.string.Cdbs));
            tvOCBC.setText(getString(R.string.Cocbc));
            tvUOB.setText(getString(R.string.Cuob));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

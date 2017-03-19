package mataram.padam.sugarormsample;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.ArrayList;
import java.util.List;

import mataram.padam.sugarormsample.entity.Book;

public class MainActivity extends ListActivity {

    List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        SugarContext.init(getApplicationContext());

        // create table if not exists
        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());

        books = Book.listAll(Book.class);
        setListAdapter(new BookAdapter(this,books));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        SugarContext.terminate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ArrayAdapter<Book> adapter = (ArrayAdapter<Book>) getListAdapter();
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.add_menu:
                Book book = new Book();
                book.setTitle("Sample Book");
                book.setAuthor("Adrew");
                book.setPrice(123000);
                book.save();
                adapter.add(book);
                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        adapter.notifyDataSetChanged();
        return true;
    }
}

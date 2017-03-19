package mataram.padam.sugarormsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import mataram.padam.sugarormsample.entity.Book;

/**
 * Created by Hendro Steven on 19/03/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    private final Context context;
    private final List<Book> books;
    NumberFormat form = NumberFormat.getCurrencyInstance();

    public BookAdapter(Context context, List<Book> books) {
        super(context, R.layout.list_book, books);
        this.context = context;
        this.books = books;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_book, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView author = (TextView) rowView.findViewById(R.id.author);
        TextView price = (TextView) rowView.findViewById(R.id.price);

        Book book = books.get(position);

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        price.setText("IDR "+ form.format(book.getPrice()));

        return rowView;
    }

}

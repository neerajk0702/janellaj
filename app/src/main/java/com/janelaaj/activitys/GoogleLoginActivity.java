package com.janelaaj.activitys;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class GoogleLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, connectTextView;
    private Button gplusAccount, complgplusRegistration;
    private CircleImageView logoImage;
    View logingLayout,complgplusRegiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlelogin);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.logingLayout = this.findViewById(R.id.logingLayout);
        this.connectTextView = this.findViewById(R.id.connectTextView);
        this.gplusAccount = this.findViewById(R.id.gplusAccount);
        this.complgplusRegiLayout = this.findViewById(R.id.complgplusRegiLayout);
        this.complgplusRegistration = this.findViewById(R.id.complgplusRegistration);

        this.gplusAccount.setOnClickListener(this);
        //this.complgplusRegiLayout.setOnClickListener(this);
        this.complgplusRegistration.setOnClickListener(this);

        String string = "Conneting To your  Google  account";
        Spannable spannable = new SpannableString(string);
        ColorStateList blueColor = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.RED});
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.BOLD, -1, blueColor, null);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.WHITE);
        spannable.setSpan(textAppearanceSpan, 19, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(backgroundColorSpan, 19, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        connectTextView.setText(spannable);

     /*   ImageSpan is = new ImageSpan(context, R.drawable.image);
        SpannableString text = new SpannableString("Left  Right");
        text.setSpan(is, 4, 4, 0);

*/
        /*

        spannable.setSpan(new BackgroundColorSpan(Color.parseColor("#ffffff")), 18, 26,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new StyleSpan(Typeface.BOLD), 18, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        connectTextView.setText(spannable);*/


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.gplusAccount) {

        } else if (v.getId() == R.id.complgplusRegistration ) {
            Intent intent = new Intent(GoogleLoginActivity.this, SelectTYpeActivity.class);
            //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }
}

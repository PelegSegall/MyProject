package com.example.myproject;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class recipe_popUp extends AppCompatActivity {

    private ListView nutri, ing, prep;
    String[]prepArray={"In a large bowl, whisk together the sugars, salt, and butter until a paste forms with no lumps.", "Whisk in the egg and vanilla, beating until light ribbons fall off the whisk and remain for a short while before falling back into the mixture.", "Sift in the flour and baking soda, then fold the mixture with a spatula (Be careful not to overmix, which would cause the gluten in the flour to toughen resulting in cakier cookies).", "Fold in the chocolate chunks, then chill the dough for at least 30 minutes. For a more intense toffee-like flavor and deeper color, chill the dough overnight. The longer the dough rests, the more complex its flavor will be.", "Preheat oven to 350°F (180°C). Line a baking sheet with parchment paper.", "Scoop the dough with an ice-cream scoop onto a parchment paper-lined baking sheet, leaving at least 4 inches (10 cm) of space between cookies and 2 inches (5 cm) of space from the edges of the pan so that the cookies can spread evenly.", "Bake for 12-15 minutes, until the edges have started to barely brown.", "Cool completely before serving.", "Enjoy!"};
    String[]ingArray={"for 12 cookies","½ cup granulated sugar(100 g)", "¾ cup brown sugar(165 g), packed", "1 teaspoon salt", "½ cup unsalted butter(115 g), melted", "1 large egg", "1 teaspoon vanilla extract", "¼ cup all-purpose flour(155 g)", "½ teaspoon baking soda", "4 oz milk or semi-sweet chocolate chunks(110 g)", "4 oz dark chocolate chunk(110 g), or your preference"};
    String[]nutriArray={"Calories 271", "Carbs 34g", "Fat 14g", "Protein 2g"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_popup);

        prep=findViewById(R.id.preparation);
        ing=findViewById(R.id.ingredients);
        nutri=findViewById(R.id.nutrients);

        PrepAdapter prepAdapter=new PrepAdapter(getApplicationContext(), prepArray);
        prep.setAdapter(prepAdapter);

        forceRTLIfSupported();
    }

    @SuppressLint("ObsoleteSdkInt")
    private void forceRTLIfSupported() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }
}

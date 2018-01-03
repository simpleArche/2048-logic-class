package simplearche.a2048_simple_exmple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import simplearche.a2048_simple_exmple.GameField;
public class MainActivity extends AppCompatActivity {
    GameField gameField;
    Button t00,t01,t02,t03,
            t10,t11,t12,t13,
            t20,t21,t22,t23,
            t30,t31,t32,t33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t00 = (Button) findViewById(R.id.t00);
        t01 = (Button) findViewById(R.id.t01);
        t02 = (Button) findViewById(R.id.t02);
        t03 = (Button) findViewById(R.id.t03);

        t10 = (Button) findViewById(R.id.t10);
        t11 = (Button) findViewById(R.id.t11);
        t12 = (Button) findViewById(R.id.t12);
        t13 = (Button) findViewById(R.id.t13);

        t20 = (Button) findViewById(R.id.t20);
        t21 = (Button) findViewById(R.id.t21);
        t22 = (Button) findViewById(R.id.t22);
        t23 = (Button) findViewById(R.id.t23);

        t30 = (Button) findViewById(R.id.t30);
        t31 = (Button) findViewById(R.id.t31);
        t32 = (Button) findViewById(R.id.t32);
        t33 = (Button) findViewById(R.id.t33);

        gameField = new GameField(4);
        gameField.setRandomElement();

        //visualize
        t00.setText(gameField.gameArray[0][0]+""); if (gameField.gameArray[0][0]== 0) t00.setText( "");
        t01.setText( gameField.gameArray[0][1]+""); if (gameField.gameArray[0][1]== 0) t01.setText( "");
        t02.setText( gameField.gameArray[0][2]+""); if (gameField.gameArray[0][2]== 0) t02.setText( "");
        t03.setText( gameField.gameArray[0][3]+""); if ( gameField.gameArray[0][3]== 0) t03.setText( "");

        t10.setText( gameField.gameArray[1][0]+""); if (gameField.gameArray[1][0]== 0) t10.setText( "");
        t11.setText( gameField.gameArray[1][1]+""); if (gameField.gameArray[1][1]== 0) t11.setText( "");
        t12.setText( gameField.gameArray[1][2]+""); if (gameField.gameArray[1][2]== 0) t12.setText( "");
        t13.setText( gameField.gameArray[1][3]+""); if (gameField.gameArray[1][3]== 0) t13.setText( "");


        t20.setText( gameField.gameArray[2][0]+""); if (gameField.gameArray[2][ 0]== 0) t20.setText( "");
        t21.setText( gameField.gameArray[2][1]+""); if (gameField.gameArray[2][1]== 0) t21.setText( "");
        t22.setText( gameField.gameArray[2][2]+""); if (gameField.gameArray[2][ 2]== 0) t22.setText( "");
        t23.setText( gameField.gameArray[2][3]+""); if (gameField.gameArray[2][3]== 0) t23.setText( "");

        t30.setText( gameField.gameArray[3][0]+""); if (gameField.gameArray[3][0]== 0) t30.setText( "");
        t31.setText( gameField.gameArray[3][1]+""); if (gameField.gameArray[3][1]== 0) t31.setText( "");
        t32.setText( gameField.gameArray[3][2]+""); if (gameField.gameArray[3][2]== 0) t32.setText( "");
        t33.setText( gameField.gameArray[3][3]+""); if (gameField.gameArray[3][3]== 0) t33.setText( "");
    }
    public void visualize(View view){
        t00.setText(gameField.gameArray[0][0]+""); if (gameField.gameArray[0][0]== 0) t00.setText( "");
        t01.setText( gameField.gameArray[0][1]+""); if (gameField.gameArray[0][1]== 0) t01.setText( "");
        t02.setText( gameField.gameArray[0][2]+""); if (gameField.gameArray[0][2]== 0) t02.setText( "");
        t03.setText( gameField.gameArray[0][3]+""); if ( gameField.gameArray[0][3]== 0) t03.setText( "");

        t10.setText( gameField.gameArray[1][0]+""); if (gameField.gameArray[1][0]== 0) t10.setText( "");
        t11.setText( gameField.gameArray[1][1]+""); if (gameField.gameArray[1][1]== 0) t11.setText( "");
        t12.setText( gameField.gameArray[1][2]+""); if (gameField.gameArray[1][2]== 0) t12.setText( "");
        t13.setText( gameField.gameArray[1][3]+""); if (gameField.gameArray[1][3]== 0) t13.setText( "");


        t20.setText( gameField.gameArray[2][0]+""); if (gameField.gameArray[2][ 0]== 0) t20.setText( "");
        t21.setText( gameField.gameArray[2][1]+""); if (gameField.gameArray[2][1]== 0) t21.setText( "");
        t22.setText( gameField.gameArray[2][2]+""); if (gameField.gameArray[2][ 2]== 0) t22.setText( "");
        t23.setText( gameField.gameArray[2][3]+""); if (gameField.gameArray[2][3]== 0) t23.setText( "");

        t30.setText( gameField.gameArray[3][0]+""); if (gameField.gameArray[3][0]== 0) t30.setText( "");
        t31.setText( gameField.gameArray[3][1]+""); if (gameField.gameArray[3][1]== 0) t31.setText( "");
        t32.setText( gameField.gameArray[3][2]+""); if (gameField.gameArray[3][2]== 0) t32.setText( "");
        t33.setText( gameField.gameArray[3][3]+""); if (gameField.gameArray[3][3]== 0) t33.setText( "");
    }
    public void upBtn(View view)
    {
        if(gameField.makeUpper())
            gameField.setRandomElement();
        visualize(view);
    }
    public void downBtn(View view)
    {
        if(gameField.makeDowner())
            gameField.setRandomElement();
        visualize(view);
    }
    public void leftBtn(View view)
    {
        if(gameField.makeLefter())
            gameField.setRandomElement();
        visualize(view);
    }
    public void rightBtn(View view)
    {
        if(gameField.makeRighter())
            gameField.setRandomElement();
        visualize(view);
    }
    public void restart(View view)
    {
        gameField = new GameField(4);
        gameField.setRandomElement();
        visualize(view);
    }
}

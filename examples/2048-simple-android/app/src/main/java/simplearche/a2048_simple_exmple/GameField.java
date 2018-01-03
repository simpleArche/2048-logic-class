package simplearche.a2048_simple_exmple;

import java.util.Random;

public class GameField {
    public int[][] gameArray;
    int gameArrayLength;
    public GameField(int arraySize)
    {
        this.gameArray = new int[arraySize][arraySize];
        this.gameArrayLength = arraySize;
        this.fillArray(0);
    }
    public void fillArray(int fillValue)
    {
        for (int i = 0; i < this.gameArrayLength; i++)
        {
            for (int j = 0; j < this.gameArrayLength; j++)
                this.gameArray[i][j] = fillValue;
        }
    }
    public void setElement(int x, int y, int value)
    {
        this.gameArray[x - 1][y - 1] = value;
    }
    public Boolean containsEmpty()
    {
        for (int i = 0; i < this.gameArrayLength; i++)
        {
            for (int j = 0; j < this.gameArrayLength; j++)
            {
                if (this.gameArray[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    public void setRandomElement()
    {
        int value = 2;
        Random rnd = new Random();
        //value = (rnd.nextInt(0+2) == 1) ? 2 : 4;

        if(this.containsEmpty())
            while (true)
            {
                int x = rnd.nextInt(0+this.gameArrayLength);
                int y = rnd.nextInt(0+this.gameArrayLength);
                if (this.gameArray[x][y] == 0)
                {
                    this.setElement(x+1, y+1, value);
                    break;
                }
            }
    }
    public void switchElements(int x1, int y1, int x2, int y2)
    {
        this.gameArray[x1][y1] += this.gameArray[x2][ y2];
        this.gameArray[x2][ y2] = this.gameArray[x1][ y1] - this.gameArray[x2][y2];
        this.gameArray[x1][y1] -= this.gameArray[x2][y2];
    }
    public Boolean makeUpper()
    {
        Boolean switchedFlag = true;
        Boolean moved = false;
        while (switchedFlag == true)
        {
            switchedFlag = false;
            for (int raw_i = 0; raw_i < this.gameArrayLength; raw_i++)
            {

                for (int line_i = this.gameArrayLength - 1; line_i > 0; line_i--)
                {
                    if (this.gameArray[line_i - 1][raw_i] == 0 && this.gameArray[line_i][raw_i]!=0)
                    {
                        this.switchElements(line_i - 1, raw_i, line_i, raw_i);
                        switchedFlag = true;
                        moved = true;
                    }
                }
            }

        }

        for (int j = 0; j < this.gameArrayLength; j++)
        {
            for (int i = 0; i < this.gameArrayLength - 1; i++)
            {
                if (this.gameArray[i][j] == this.gameArray[i + 1][j] && this.gameArray[i][j] != 0)
                {

                    for (int i2 = i + 1; i2 < this.gameArrayLength - 1; i2++)
                    {
                        this.gameArray[i2][j] = this.gameArray[i2 + 1][j];
                    }
                    this.gameArray[i][j] *= 2;
                    this.gameArray[this.gameArrayLength - 1][j] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }
    public Boolean makeDowner() {
        Boolean switchedFlag = true;
        Boolean moved = false;
        while (switchedFlag == true)
        {
            switchedFlag = false;
            for (int raw_i = 0; raw_i < this.gameArrayLength; raw_i++)
            {

                for (int line_i = 0; line_i < this.gameArrayLength - 1; line_i++)
                {
                    if (this.gameArray[line_i + 1][raw_i] == 0 && this.gameArray[line_i][ raw_i] != 0)
                    {
                        this.switchElements(line_i + 1, raw_i, line_i, raw_i);
                        switchedFlag = true;
                        moved = true;
                    }
                }
            }

        }
        for(int j=0;j< this.gameArrayLength; j++)
        {
            for(int i= this.gameArrayLength - 1;i>0;i--)
            {
                if(this.gameArray[i][j]== this.gameArray[i-1][j]&& this.gameArray[i][j]!=0)
                {
                    for(int i2=i;i2>0;i2--)
                    {
                        this.gameArray[i2][j]= this.gameArray[i2-1][j];
                    }
                    this.gameArray[i][j]*=2;
                    this.gameArray[0][j]=0;
                    moved = true;
                }
            }
        }
        return moved;
    }
    public  Boolean makeLefter()
    {
        Boolean switchedFlag = true;
        Boolean moved = false;
        while (switchedFlag == true)
        {
            switchedFlag = false;
            for (int line_i = 0; line_i < this.gameArrayLength; line_i++)
            // for (int raw_i = 0; raw_i < this.gameArrayLength; raw_i++)
            {

                //   for (int line_i = this.gameArrayLength - 1; line_i > 0; line_i--)
                for (int raw_i = this.gameArrayLength - 1; raw_i > 0; raw_i--)
                {
                    if (this.gameArray[line_i][raw_i - 1] == 0 && this.gameArray[line_i][raw_i] != 0)
                    {
                        this.switchElements(line_i, raw_i-1, line_i, raw_i);
                        switchedFlag = true;
                        moved = true;
                    }


                }
            }
        }
        for (int i = 0; i < this.gameArrayLength; i++)
        {
            for (int j = 0; j < this.gameArrayLength - 1; j++)
            {
                if (this.gameArray[i][j] == this.gameArray[i][j + 1] && this.gameArray[i][j] != 0)
                {
                    for (int j2 = j + 1; j2 < this.gameArrayLength - 1; j2++)
                    {
                        this.gameArray[i][j2] = this.gameArray[i][j2 + 1];
                    }
                    this.gameArray[i][j] *= 2;
                    this.gameArray[i][this.gameArrayLength - 1] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }
    public Boolean makeRighter()
    {
        Boolean switchedFlag = true;
        Boolean moved = false;
        while (switchedFlag == true)
        {
            switchedFlag = false;
            //  for (int raw_i = 0; raw_i < this.gameArrayLength; raw_i++)
            for (int line_i = 0; line_i < this.gameArrayLength; line_i++)
            {

                //    for (int line_i = 0; line_i < this.gameArrayLength - 1; line_i++)
                for (int raw_i = 0; raw_i < this.gameArrayLength - 1; raw_i++)
                {
                    if (this.gameArray[line_i][raw_i + 1] == 0 && this.gameArray[line_i][raw_i] != 0)
                    {

                        this.switchElements(line_i, raw_i+1, line_i, raw_i);
                        switchedFlag = true;
                        moved = true;
                    }

                }
            }
        }
        for (int i = 0; i < this.gameArrayLength; i++)
        {
            for (int j = this.gameArrayLength - 1; j > 0; j--)
            {
                if (this.gameArray[i][j] == this.gameArray[i][ j - 1] && this.gameArray[i][j] != 0)
                {

                    for (int j2 = j - 1; j2 > 0; j2--)
                    {
                        this.gameArray[i][j2] = this.gameArray[i][j2 - 1];
                    }
                    this.gameArray[i][ j] *= 2;
                    this.gameArray[i][0] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }
}

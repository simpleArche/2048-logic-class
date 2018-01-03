using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2048_2
{

    public partial class Form1 : Form
    {
        GameField gameField;
        public Form1()
        {
            InitializeComponent();
        }

        private void visBtn_Click(object sender, EventArgs e)
        {
            t00.Text = gameField.gameArray[0, 0].ToString(); if (t00.Text == "0") t00.Text = "";
            t01.Text = gameField.gameArray[0, 1].ToString(); if (t01.Text == "0") t01.Text = "";
            t02.Text = gameField.gameArray[0, 2].ToString(); if (t02.Text == "0") t02.Text = "";
            t03.Text = gameField.gameArray[0, 3].ToString(); if (t03.Text == "0") t03.Text = "";

            t10.Text = gameField.gameArray[1, 0].ToString(); if (t10.Text == "0") t10.Text = "";
            t11.Text = gameField.gameArray[1, 1].ToString(); if (t11.Text == "0") t11.Text = "";
            t12.Text = gameField.gameArray[1, 2].ToString(); if (t12.Text == "0") t12.Text = "";
            t13.Text = gameField.gameArray[1, 3].ToString(); if (t13.Text == "0") t13.Text = "";


            t20.Text = gameField.gameArray[2, 0].ToString(); if (t20.Text == "0") t20.Text = "";
            t21.Text = gameField.gameArray[2, 1].ToString(); if (t21.Text == "0") t21.Text = "";
            t22.Text = gameField.gameArray[2, 2].ToString(); if (t22.Text == "0") t22.Text = "";
            t23.Text = gameField.gameArray[2, 3].ToString(); if (t23.Text == "0") t23.Text = "";

            t30.Text = gameField.gameArray[3, 0].ToString(); if (t30.Text == "0") t30.Text = "";
            t31.Text = gameField.gameArray[3, 1].ToString(); if (t31.Text == "0") t31.Text = "";
            t32.Text = gameField.gameArray[3, 2].ToString(); if (t32.Text == "0") t32.Text = "";
            t33.Text = gameField.gameArray[3, 3].ToString(); if (t33.Text == "0") t33.Text = "";
            // MessageBox.Show("refreshed");

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            gameField = new GameField(4);
            gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void setBtn_Click(object sender, EventArgs e)
        {
            gameField.setElement(1, 2, 1024);
            visBtn_Click(sender, e);
        }

        private void testbtn_Click(object sender, EventArgs e)
        {
            gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void up_Click(object sender, EventArgs e)
        {
            if(gameField.makeUpper())
                gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void down_Click(object sender, EventArgs e)
        {
            if(gameField.makeDowner())
                gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void right_Click(object sender, EventArgs e)
        {
            if(gameField.makeRighter())
                gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void left_Click(object sender, EventArgs e)
        {
            if(gameField.makeLefter())
                gameField.setRandomElement();
            visBtn_Click(sender, e);
        }

        private void restart_Click(object sender, EventArgs e)
        {
         
        }
    }
    public class GameField
    {
        public int[,] gameArray;
        int gameArrayLength;
        public GameField(int arraySize)
        {
            gameArray = new int[arraySize, arraySize];
            gameArrayLength = arraySize;
            this.fillArray(0);
        }
        public void fillArray(int fillValue)
        {
            {

                for (int i = 0; i < gameArrayLength; i++)
                {
                    for (int j = 0; j < gameArrayLength; j++)
                        gameArray[i, j] = fillValue;
                }
            }
        }
        public void setElement(int x, int y, int value)
        {
            this.gameArray[x - 1,y - 1] = value;
        }
        public Boolean containsEmpty()
        {
            foreach (var item in this.gameArray)
            {
                if (item == 0)
                    return true;
            }
            return false;
        }
        public void setRandomElement()
        {
            Random rnd = new Random();
             int value = (rnd.Next(0, 2) == 1) ? 2 : 4;
            if(this.containsEmpty())
            while (true)
            {
                int x = rnd.Next(0, this.gameArrayLength);
                int y = rnd.Next(0, this.gameArrayLength);
                if (this.gameArray[x, y] == 0)
                {
                    this.setElement(x+1, y+1, value);
                    break;
                }
            }
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
                        if (this.gameArray[line_i - 1, raw_i] == 0 && this.gameArray[line_i, raw_i]!=0)
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
                    if (this.gameArray[i,j] == this.gameArray[i + 1,j] && this.gameArray[i,j] != 0)
                    {

                        for (int i2 = i + 1; i2 < this.gameArrayLength - 1; i2++)
                        {
                            this.gameArray[i2,j] = this.gameArray[i2 + 1,j];
                        }
                        this.gameArray[i,j] *= 2;
                        this.gameArray[this.gameArrayLength - 1,j] = 0;
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
                        if (this.gameArray[line_i + 1, raw_i] == 0 && this.gameArray[line_i, raw_i] != 0)
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
			        if(this.gameArray[i,j]== this.gameArray[i-1,j]&& this.gameArray[i,j]!=0)
			        {
				        for(int i2=i;i2>0;i2--)
				        {
                            this.gameArray[i2,j]= this.gameArray[i2-1,j];
				        }
                        this.gameArray[i,j]*=2;
                        this.gameArray[0,j]=0;
                        moved = true;
                    }
		        }
	        }
            return moved;
        }
        public Boolean makeLefter()
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
                        if (this.gameArray[line_i, raw_i - 1] == 0 && this.gameArray[line_i, raw_i] != 0)
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
                    if (this.gameArray[i,j] == this.gameArray[i,j + 1] && this.gameArray[i,j] != 0)
                    {
                        for (int j2 = j + 1; j2 < this.gameArrayLength - 1; j2++)
                        {
                            this.gameArray[i,j2] = this.gameArray[i,j2 + 1];
                        }
                        this.gameArray[i,j] *= 2;
                        this.gameArray[i,this.gameArrayLength - 1] = 0;
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
                        if (this.gameArray[line_i, raw_i + 1] == 0 && this.gameArray[line_i, raw_i] != 0)
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
                    if (this.gameArray[i, j] == this.gameArray[i, j - 1] && this.gameArray[i, j] != 0)
                    {

                        for (int j2 = j - 1; j2 > 0; j2--)
                        {
                            this.gameArray[i, j2] = this.gameArray[i, j2 - 1];
                        }
                        this.gameArray[i, j] *= 2;
                        this.gameArray[i, 0] = 0;
                        moved = true;
                    }
                }
            }
            return moved;
        }
        public void switchElements(int x1, int y1, int x2, int y2)
        {
            this.gameArray[x1, y1] += this.gameArray[x2, y2];
            this.gameArray[x2, y2] = this.gameArray[x1, y1] - this.gameArray[x2, y2];
            this.gameArray[x1, y1] -= this.gameArray[x2, y2];
        }
        
    }
}

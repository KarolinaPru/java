using System;
using System.Collections.Generic;
using System.ComponentModel.Design.Serialization;
using System.Linq;
using System.Runtime.Serialization.Formatters;
using System.Text;
using System.Threading.Tasks;

namespace Homework1
{
    class Logic
    {
        private int a;
        private int b;
        private int c;
        private int d;
        public void Start()
        {
            ObtainFourParametersFromUser();

            string mask = new String('X', a+b+c+d);
            Console.WriteLine("Wpisz tekst bez spacji o poprawnej długości: " + mask);

            string inputText = Console.ReadLine();
            string inputTransformed = inputText;

            List<string> allCombinations = new List<string>();

         //   do
       //     {

                for (int i = 0; i < 10; i++)
                {
                    string chunk1 = inputTransformed.Substring(0, a);
                    string chunk2 = inputTransformed.Substring(a+1, b);
                    string chunk3 = inputTransformed.Substring(b+1, c);
                    string chunk4 = inputTransformed.Substring(c+1, d);

                    inputTransformed = chunk2 + chunk4 + chunk1 + chunk3;

                    Console.WriteLine(inputTransformed);
                    //   allCombinations.Add(inputTransformed);
                }
                //    } while (inputText != inputTransformed);


            Console.WriteLine(allCombinations.Distinct());

            Console.WriteLine(inputText);
            Console.ReadKey();
        }

        private void ObtainFourParametersFromUser()
        {
            Console.Write("Podaj liczbę a: ");
            a = ObtainProperInputFromUser();

            Console.Write("Podaj liczbę b: ");
            b = ObtainProperInputFromUser();

            Console.Write("Podaj liczbę c: ");
            c = ObtainProperInputFromUser();

            Console.Write("Podaj liczbę d: ");
            d = ObtainProperInputFromUser();
        }

        private int ObtainProperInputFromUser()
        {
            string input = Console.ReadLine();
            int i = 0;
            bool isValid = validateInput(input);
            if (isValid)
            {
                i = int.Parse(input);
            }
            else
            {
                Console.Write("Podaj poprawną liczbę: ");
                return ObtainProperInputFromUser();
            }
            return i;
        }

        private bool validateInput(string s)
        {
            int i;
            bool isInteger = int.TryParse(s, out i);
            return isInteger;
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.Design.Serialization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homework1
{
    class Logic
    {
        public void Start()
        {
            Console.Write("Podaj liczbę a: ");
            int a = ObtainProperInputFromUser();
           
            Console.Write("Podaj liczbę b: ");
            int b = ObtainProperInputFromUser();

            Console.Write("Podaj liczbę c: ");
            int c = ObtainProperInputFromUser();

            Console.Write("Podaj liczbę d: ");
            int d = ObtainProperInputFromUser();
            
            Console.ReadKey();
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
                ObtainProperInputFromUser();
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

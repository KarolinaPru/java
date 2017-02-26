using System;
using System.Linq;

namespace Feb20workshop
{
    class Logic
    {
        public void Start()
        {
            Console.Write("Podaj x: ");
            var x = Convert.ToInt32(Console.ReadLine());

            Console.Write("Podaj y: ");
            var y = Convert.ToInt32(Console.ReadLine());

            var mask = new string('X', x + y);
            Console.WriteLine(mask);

            var inputWord = Console.ReadLine();

            // string implementuje interfejs IEnumerable or IQueryable 
            // LINQ - metody rozszerzające - dla implementujących te interfejsy - szybkie wyszukiwanie -jak SQL

            bool inputIsLowerCase = !inputWord.Any(char.IsUpper);

            var inputTransformed = inputWord;
            do
            {
                string inputFirstPart = inputTransformed.Substring(0, x);
                string inputSecondPart = inputTransformed.Substring(x, y); // indeks, długość

                inputTransformed = inputSecondPart + inputFirstPart;

                // wypisz tylko te kombinacje, które zaczynają się wielką literą
                // jeśli cały tekst z małej - wypisz wszystko
                if (IsFirstLetterCapital(inputTransformed) || inputIsLowerCase)
                {
                    // GOAL: write all combinations
                    Console.WriteLine(inputTransformed);
                }
            } while (inputWord != inputTransformed);

            Console.WriteLine(inputWord);

            Console.ReadKey();
        }

        private bool IsFirstLetterCapital(string inputTransformed)
        {
            return char.IsUpper(inputTransformed[0]);
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;

namespace Homework1
{
    internal class Logic
    {
        private int _a;
        private int _b;
        private int _c;
        private int _d;
        private List<string> _allCombinations;

        public void Start()
        {
            ObtainFourParametersFromUser();

            var mask = new string('X', _a + _b + _c + _d);

            Console.WriteLine("Wpisz tekst bez spacji o poprawnej długości: " + mask);

            _allCombinations = GetAllCombinations();

            PrintUniqueCombinations();

            Console.ReadKey();
        }

        private void ObtainFourParametersFromUser()
        {
            Console.Write("Podaj liczbę a: ");
            _a = ObtainValidInputFromUser();

            Console.Write("Podaj liczbę b: ");
            _b = ObtainValidInputFromUser();

            Console.Write("Podaj liczbę c: ");
            _c = ObtainValidInputFromUser();

            Console.Write("Podaj liczbę d: ");
            _d = ObtainValidInputFromUser();
        }

        private int ObtainValidInputFromUser()
        {
            var input = Console.ReadLine();
            var i = 0;
            var isValid = validateInput(input);
            if (isValid)
            {
                i = int.Parse(input);
            }
            else
            {
                Console.Write("Podaj poprawną liczbę: ");
                return ObtainValidInputFromUser();
            }
            return i;
        }

        private bool validateInput(string s)
        {
            int i;
            var isInteger = int.TryParse(s, out i);
            return isInteger;
        }

        private List<string> GetAllCombinations()
        {
            var inputText = Console.ReadLine();
            var inputTransformed = inputText;

            var allCombinations = new List<string>();

            do
            {
                var chunk1 = inputTransformed.Substring(0, _a);
                var chunk2 = inputTransformed.Substring(_a, _b);
                var chunk3 = inputTransformed.Substring(_a + _b, _c);
                var chunk4 = inputTransformed.Substring(_a + _b + _c, _d);

                inputTransformed = chunk2 + chunk4 + chunk1 + chunk3;

                allCombinations.Add(inputTransformed);

            } while (inputText != inputTransformed);

            return allCombinations;
        }
        
        private void PrintUniqueCombinations()
        {
            IEnumerable<string> uniqueCombinations = _allCombinations.Distinct();

            foreach (var s in uniqueCombinations)
                Console.WriteLine(s);
        }
    }
} 
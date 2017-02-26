using System;
using System.Collections;using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homework2
{
    class Logic
    {
        private readonly Answers _a;

        public Logic(Answers a)
        {
            this._a = a;
            _a.SetAnswerDictionary();
        }

        public void Start()
        {
            Console.Write("Zadaj pytanie: ");

            string[] input = Console.ReadLine().Split();
            var question = input[0].ToLower();

            Random random = new Random();

            if (_a.answerList.ContainsKey(question))
            {
                var setOfAnswers = _a.answerList[question];
                
                int randomIndex = random.Next(0, setOfAnswers.Count);
                string answer = setOfAnswers[randomIndex];
                Console.WriteLine(answer);
                
            }
            else if (question == "koniec")
            {
                Environment.Exit(0);
            }
            else
            {
                int randomIndex = random.Next(0, _a.randomList.Count);
                string answer = _a.randomList[randomIndex];

                Console.WriteLine(answer);
            }

            Console.ReadKey();
        }
    }
}

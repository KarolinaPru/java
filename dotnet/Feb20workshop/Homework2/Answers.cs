using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homework2
{
    class Answers
    {
        public Dictionary<string, List<string>> answerList = new Dictionary<string, List<string>>();
        private List<string> _closedEndedList;
        private List<string> _adverbList;
        private List<string> _maleAdjectiveList;
        private List<string> _femaleAdjectiveList;
        private List<string> _neuterAdjectiveList;
        private List<string> _thingList;
        private List<string> _personList;
        private List<string> _numberList;
        public List<string> randomList;

        public Dictionary<string, List<string>> SetAnswerDictionary()
        {
            InitializeListsOfAnswers();
            answerList.Add("czy", _closedEndedList);
            answerList.Add("jak", _adverbList);
            answerList.Add("ile", _numberList);
            answerList.Add("kto", _personList);
            answerList.Add("co", _thingList);
            answerList.Add("jaki", _maleAdjectiveList);
            answerList.Add("jaka", _femaleAdjectiveList);
            answerList.Add("jakie", _neuterAdjectiveList);

            return answerList;
        }

        private void InitializeListsOfAnswers()
        {

            _closedEndedList = new List<string>
            {
                "Tak", "Nie", "Może", "Nie wiem", "Chyba tak", "Chyba nie"
            };
            
            _adverbList = new List<string>
            {
                "Dobrze", "Źle", "Tak sobie", "Wspaniale", "Niesamowicie", "Kolorowo", "Super!"
            };

            _maleAdjectiveList = new List<string>
            {
                "Niezły", "Bajerancki", "Świetny", "Beznadziejny", "Różowy", "Czerwony", "Niebieski"
            };

            _femaleAdjectiveList = new List<string>
            {
                "Niezła", "Bajerancka", "Świetna", "Beznadziejna", "Różowa", "Czerwona", "Niebieska"
            };

            _neuterAdjectiveList = new List<string>
            {
                "Niezłe", "Bajeranckie", "Świetne", "Beznadziejne", "Różowe", "Czerwone", "Niebieskie"
            };

            _thingList = new List<string>
            {
                "Krzesło", "Świnka", "Pies preriowy", "Piłka", "Tramwaj", "Nic"
            };

            _personList = new List<string>
            {
                "Kamil", "Karolina", "Konrad", "Paweł", "Tomek", "Nikt"
            };

            randomList = new List<string>
            {
                "Oddalam to pytanie", "Proszę o następny zestaw pytań", "Nie mam pojęcia", "Hmmmm..."
            };

            _numberList = new List<string>();

            for (int i = 0; i< 101; i++)
            {
                _numberList.Add(i.ToString());
            }

        }
    }
}

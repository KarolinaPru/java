using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Feb20Class
{
    class Program
    {
        static void Main(string[] args)
        {
            int x;
            int y;
            string nazwa;
            string nazwaPoKonwersji;

            Console.Write("Podaj x: ");
            x = Convert.ToInt32(Console.ReadLine());
            Console.Write("Podaj y: ");
            y = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine(new string('X', x + y));
            nazwa = Console.ReadLine();

            nazwaPoKonwersji = nazwa;

            bool maWielkaLitera = false;
            foreach (char c in nazwaPoKonwersji)
            {
                maWielkaLitera = maWielkaLitera ? maWielkaLitera : char.IsUpper(c);
            }

            do
            {
                string pierwszaPołowa = nazwaPoKonwersji.Substring(0, x);
                string drugaPołowa = nazwaPoKonwersji.Substring(x, y);    // indeks, długość

                nazwaPoKonwersji = drugaPołowa + pierwszaPołowa;

                if (char.IsUpper(nazwaPoKonwersji[0]) || !maWielkaLitera)
                {
                    Console.WriteLine(nazwaPoKonwersji);
                }  
            }
            while (nazwa != nazwaPoKonwersji);

            Console.WriteLine(nazwa);

            Console.ReadKey();
        }
    }
}

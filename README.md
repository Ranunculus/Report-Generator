# Report-Generator
Texuna test task

#Requirments (in Russian):

Написать генератор текстовых отчётов.

а) отчет должен быть разбит на страницы определённой ширины и высоты <br/>
б) страницы отделяются друг от друга отдельной строкой содержащей один единственный символ ~<br/>
в) высота страницы не включает себя разделитель страниц<br/>
г) заголовок и данные внутри колонки должны быть выравнены влево<br/>
д) заголовки и данные в строке отделяются друг от друга символом |<br/>
е) слева и справа от заголовка/значения всегда должно быть по одному пробелу<br/>
ё) ширина колонок фиксирована в символах<br/>
ж) ширина колонок не включает в себя пробелы слева и справа от заголовка/значения<br/>
з) для заполнения неиспользованного места справа добавляются пробелы<br/>
и) заголовки колонок должны быть повторены на каждой странице <br/>
й) строки данных в отчете отделяются друг от друга (и от заголовка) строкой символов - <br/>
к) для перехода на новую строку должен использоваться системный разделитель строк<br/>
л) ширина страницы не включает в себя разделитель строк <br/>
м) если заголовок или значение не умещается в отведённое место, то значение должно быть принудительно разбито<br/>
н) разбиенние должно производиться по границе слов, если это возможно<br/>
о) если разбиение по границе слов невозможно - то разбивать прямо посередине слова<br/>
п) границей слова является любой символ кроме букв и цифр<br/>
р) настройки подаются в виде ХМЛ файла (см. пример в settings.xml)<br/>
с) данные подаются в виде TAB-delimited файла в кодировке UTF-16 (см. пример в source-data.tsv)<br/>
т) результат должен быть записан в файл в кодировке UTF-16<br/>
у) использовать нужно язык Java<br/>
ф) разрешается использовать любые готовые библиотеки<br/>
х) все остальные нюансы, не детализированные выше, остаются на усмотрение разработчика<br/>
ц) все решения, принятые разработчиком, должны быть описаны в сопроводительной записке<br/>
ч) разрешается менять любое требование<br/>
ш) любые изменения к требованиям должны быть описаны в сопроводительной записке<br/>

2) Образец настроек

Ширина: 32
Высота: 12
Колонки:
- Номер, 8 символов
- Дата, 7 символов
- ФИО, 7 символов

см. settings.xml

3) Образец настроек исходных данных

Внимание, здесь данные даны с кавычками и запятыми. В файле нет кавычек и в качестве разделителей используется табуляция!

 "1", "25/11", "Павлов Дмитрий"
 "2", "26/11", "Павлов Константин"
 "3", "27/11", "Н/Д"
 "4", "28/11", "Ким Чен Ир"
 "5", "29/11/2009", "Юлианна-Оксана Сухово-Кобылина"

см. source-data.tsv

4) Пример вызова генератора

java Generator.class settings.xml source-data.tsv example-report.txt

5) См. результат генерации и комментарии к нему в файле example-report.txt

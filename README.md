# 红岩第四次作业-Level3-钱可欣-2019210107
----
##### 说来惭愧，上节课讲的东西都没怎么听懂，作业完全无从下手，只能重新看书，又发生了一些变故导致最近学习的时间变得很混乱，直到周四晚上才开始写这个作业，lv4估计没时间写也没什么思路，就转战lv3，说实话写完了还有点蒙，不知道自己到底有没有写对（虽然好像确实是按着要求来的）。总之开始正题
### 作业要求：写一个行编辑程序，接受从控制台输入的数据，并存下来。由于用户在控制台进行输入时，不能保证不 出错，因此，需要设立一个缓冲区，接受输入的字符。允许用户输入出差错，并在发现有误时可以及时更正。例如，当用户发现刚刚键入的一个字符是错误的时候时，可以补进退格符"#b"，表示前一个字符 无效；如果发现键入的行内差错太多或难以补救，可以使用退行符"#c"，以表示在当前行中的所有字符 无效。同时，从控制台中每一行每一行读取数据，当行末尾为"#o"，则表示用户输入结束，否则，继续 从控制台读取
### 因为翻书的时候正好看到了缓冲区，（尽管感觉好像上节课没讲这个难道我没听吗但想不到其他的了）所以就用这个写了。
### 写的时候倒是没什么问题（果然是我写错了吧），感觉就和数组差不多啊……考虑到退格清行符，建立了两个缓冲区，一个用来接收每行的输入（buf1），一个将输入处理后存储起来（buf2）。
### 但一开始写好的时候莫名报错，在输入了第一行并没有加#o符号的情况下敲了回车然后出了问题，原因是将buf1中的数据传给buf2时用的是
```
buf2.put(buf1.get());
```
### 能不报错吗摔！
### 一开始定义了个c来接收buf1.get，然后改成buf2.put(c)就ok了
### 结果刚刚在试自己为什么报错（已经忘记了）的时候又发现一个问题，就是在输入#后面加其他符号还是要全部照原样输出的，因为一开始的思路是读到‘#’号就开始判断，忘记了会有其实并不是退格符一类的情况，就在switch后面加了一个defaut就好了
#### 话说这次程序也没面向对象，我果然是写错了吧……

#Question
Link: http://stackoverflow.com/q/28244660/1581725

#Answer
Link: http://stackoverflow.com/a/28244874/1581725

**Direct solution:**

    String[] carry = createVessel();

I prepared an example where you can see that this will compile and run (if you have a main method) Simply follow this link: http://goo.gl/fQMpKJ and it will get you to this:
![Online Example][1]

**Why?**
The problem is that you can't *execute* assignments to fields directly in the body of a class - if it's not in the direct declaration of fields. For this purpose you have the constructor where you could write something like:

    public GameControl(){
        carry = createVessel();
    }

Then you could stay with `String[] carry = new String[2];` because the `String[]` which will be created inside the `createVessel()` method would override it. Another way would to use a main method:

    public static void main(String[] args) {
        carry = createVessel();
    }

But of course you then need to also assign `static` to the `String[] carry` and the method `createVessel();`

If you have another question, feel free to comment - I will be back on this question later. Also I can see you are not really familiar with Java so maybe the Oracle Tutorials will help http://docs.oracle.com/javase/tutorial/ a little bit.


  [1]: http://i.stack.imgur.com/lR68B.png
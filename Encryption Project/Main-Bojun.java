class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] sub = new char[5];
    sub[0] = 'a';
    sub[1] = 'e';
    sub[2] = 'i';
    sub[3] = 'o';
    sub[4] = 'u';

    char[] sub2 = new char[5];
    sub2[0] = '\u2663';  // Club
    sub2[1] = '\u2660';  // Spade
    sub2[2] = '\u2665';  // Heart
    sub2[3] = '\u2666';  // Diamond
    sub2[4] = '\u2836';  // Bralle symbol

    
    // Encoding message
    String file = Input.readFile("Original.txt");

    //substituion
    String encodedMsg1 = subEncryption(file,sub,sub2);
    Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    String encodedMsg2 = encode(encodedMsg1);
    Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    String encodedMsg3 = reverse(encodedMsg2);
    Input.writeFile("Encode3.txt",encodedMsg3);
	
	//railFence
	String encodedMsg4 = railFence(encodedMsg3);
    Input.writeFile("Encode4.txt",encodedMsg4);

    
    // decoding message
    String file2 = Input.readFile("Encode3.txt");
    
    String decodedMsg1 = reverse(file2);
    Input.writeFile("Decode1.txt", decodedMsg1);
    
    String decodedMsg2 = decode(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);
    
    String decodedMsg3 = subEncryption(decodedMsg2, sub2, sub);
    Input.writeFile("Decode3.txt", decodedMsg3);
    
    
  }
  // reverse string
  String reverse(String txt){
    String bld ="";
    for(int x=0; x<= txt.length()-1; x++){
      bld = txt.charAt(x) + bld;
    }
    return bld;
  }
  
  
  //Cipher encoding with no wrapping
  String encode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii+=1;
      bld+= (char)ascii;
    }
     
    return bld;
  }

  
  String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii-=1;
      bld+= (char)ascii;
    }
    return bld;
  }

  // Substituion encoding
  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      index=indexOf(ch,sub);
      if(index!=-1){
        bld+=sub2[index];
      }
      else{
        bld+=ch;
      }
    }
    return bld;
  }
  
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
    return -1;
  }
  
   String railFence(String txt){
	   String output = "";
	   int len = input.length();
	   
	   print("Input String :" + input);
	   for(int x=0; x<len; x+=4){
		   output += input.charAt(x);
	   }
	   for(int x=1; x<len; x+=4){
		   output += input.charAt(x);
	   }
	   
	   return "Ciphered Text:" +output;
   }
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}
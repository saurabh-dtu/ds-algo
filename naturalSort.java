/*
Sorting like files/folders are sorted
Example - input = {"abc2", "abc", "xy98z", "2abh", "13abh", "xy9z", "99" , "4"};
Normal sorting output based on ASCII character value - 13abh, 2abh, 4, 99, abc, abc2, xy98z, xy9z
Natural sorting sorts based on number and string value 
*/
public class Main {
    public static void main(String[] args) {
        String[] arr = {"abc2", "abc", "xy98z", "2abh", "13abh", "xy9z", "99" , "4"};
        Main obj = new Main();
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if (obj.compareString(arr[j], arr[j + 1])) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }   
        }
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    
    public boolean compareString(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int i=0,j=0;
        while(i<al && j<bl) {
            char ca = a.charAt(i);
            char cb = b.charAt(j);
            if(isCharacter(ca) && isCharacter(cb)) {
                if(ca>cb) {
                    return true;
                } else if(ca<cb) {
                    return false;
                }
                i++;
                j++;
            } else {
                if(isCharacter(ca) && !isCharacter(cb)) {
                    return true;
                } else if(!isCharacter(ca) && isCharacter(cb)) {
                    return false;
                }
                String na = getNumber(a, i, al);
                String nb = getNumber(b, j, bl);
                int flag = compareNumber(na, nb);
                if(flag > 0) {
                    return true;
                } else if(flag < 0) {
                    return false;
                }
                i += na.length();
                j += nb.length();
            }
        }
        if(i<al) {
            return true;
        }
        return false;
    }
    
    int compareNumber(String na, String nb) {
        int n1 = Integer.parseInt(na);
        int n2 = Integer.parseInt(nb);
        if(n1>n2) {
            return 1;
        } else if (n1<n2) {
            return -1;
        }
        return 0;
    }
    
    boolean isCharacter(char a) {
        if(a>='a' && a<='z')
            return true;
        return false;
    }
    
    String getNumber(String s, int i, int l) {
        String z = "";
        while(i<l && !isCharacter(s.charAt(i))) {
            z += s.charAt(i);
            i++;
        }
        return z;
    }
}

/*
Output - 
2abh
4
13abh
99
abc
abc2
xy9z
xy98z
*/

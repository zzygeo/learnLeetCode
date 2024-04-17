package hashTable;

public class CanConstruct {
    public static void main(String[] args) {

    }

    public static boolean test(String ransomNote, String magazine){
        int[] arr = new int[26];

        for(char c : magazine.toCharArray()){
            arr[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            arr[c - 'a'] -= 1;
        }


        for(int i : arr){
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}

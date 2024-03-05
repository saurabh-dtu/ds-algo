//generate all the possible valid paranthesis of length n*2
class GenerateParenthesis {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        brackets(n*2, 0, 0, "");
        return res;
    }

    private void brackets(int n, int strl, int strr, String str) {
        if(strl+strr == n) {
            res.add(str);
            return;
        }
        if(strl < n/2)
            brackets(n, strl + 1, strr, str + '(');
        if(strr < strl) {
            brackets(n, strl, strr + 1, str + ')');
        }
    }
}

//any length b/w min 8 (strength) - max 16 
//AplhaNuremic (upper and lower), special
//atleast - one upper case, one lower, one numeric, one special character (!@#$%^&*)
function generateRandomPassword(length) {
  let special = "!@#$%^&*";
  let num = "0123456789";
  let upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let lower = "abcdefghijklmnopqrstuvwxyz";
  let pass = "";
  let specialL = special.length;
  let numL = num.length;
  let upperL = upper.length;
  let lowerL = lower.length;
  let maxUpperLength = Math.ceil(Math.random() * (length - 3));
  let maxLowerLength = Math.ceil(Math.random() * (length - 2 - maxUpperLength));
  let maxNumLength = Math.ceil(Math.random() * (length - 1 - maxUpperLength - maxLowerLength));
  let maxSpecialLength = length - maxUpperLength - maxLowerLength - maxNumLength;
  for(let i=0;i<maxUpperLength;i++) {
    pass += upper.charAt(Math.random() * upperL);
  }
  for(let i=0;i<maxLowerLength;i++) {
    pass += lower.charAt(Math.random() * lowerL);
  }
  for(let i=0;i<maxNumLength;i++) {
    pass += num.charAt(Math.random() * numL);
  }
  for(let i=0;i<maxSpecialLength;i++) {
    pass += special.charAt(Math.random() * specialL);
  }
  return pass;
}

class Solution:
    def intToRoman(self, num: int) -> str:
        res = ""
        symbols = "IVXLCDM"
        cur_idx = 0
        while num != 0:
            last_digit = num % 10
            if last_digit == 9:
                res = symbols[cur_idx] + symbols[cur_idx + 2] + res
            elif last_digit == 4:
                res = symbols[cur_idx] + symbols[cur_idx + 1] + res
            elif last_digit > 5:
                res = symbols[cur_idx + 1] + (last_digit - 5) * symbols[cur_idx] + res
            elif last_digit < 5:
                res = last_digit * symbols[cur_idx] + res
            else:
                res = symbols[cur_idx + 1] + res
            num //= 10
            cur_idx += 2
        return res

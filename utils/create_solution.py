import sys
import os

if __name__ == '__main__':
    solution_number = input("문제 코드를 입력 :")
    source_path = 'C:/Users/offset/IdeaProjects/codingTest/src/programmers'
    source_codes = os.listdir(source_path)

    seqList = []

    for source_code in source_codes:
        seq = source_code.split("_")[1]
        if "." in seq:
            seq = seq.split(".")[0]
        seqList.append(int(seq))

    seqList.sort(reverse=True)

    max_seq = 1
    if len(seqList) > 0:
        max_seq = seqList[0] + 1

    new_file_name = f"Solution_{max_seq:0>3}_{solution_number}"

    with open(f"{source_path}/{new_file_name}.java", "w", encoding="UTF-8") as f:
        f.write("package programmers;")
        f.write("\n")
        f.write(f"public class {new_file_name} " + "{")
        f.write("\n\n}")
        f.write("\n")

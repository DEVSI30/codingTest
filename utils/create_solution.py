import os


def create_file(max_seq, solution_number):
    new_file_name = f"Solution_{max_seq:0>3}_{solution_number}"

    with open(f"{source_path}/{new_file_name}.java", "w", encoding="UTF-8") as f:
        f.write("package programmers;")
        f.write("\n")
        f.write(f"public class {new_file_name} " + "{")
        f.write("\n\n}")
        f.write("\n")


if __name__ == '__main__':
    solution_number = input("문제 코드를 입력 :")
    source_path = 'C:/Users/offset/IdeaProjects/codingTest/src/programmers'
    source_codes = os.listdir(source_path)

    seqList = []
    solved_solution_number_list = []

    for source_code in source_codes:
        seq = source_code.split("_")[1]
        if len(source_code.split("_")) > 2:
            solved_solution_number = source_code.split("_")[2].split(".")[0]
            solved_solution_number_list.append(solved_solution_number)
        if "." in seq:
            seq = seq.split(".")[0]
        seqList.append(int(seq))

    seqList.sort(reverse=True)

    if solution_number not in solved_solution_number_list:
        max_seq = 1
        if len(seqList) > 0:
            max_seq = seqList[0] + 1
        create_file(max_seq, solution_number)
        pass
    else:
        print("이미 푼 문제입니다")


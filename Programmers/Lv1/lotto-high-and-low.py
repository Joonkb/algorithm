def solution(lottos, win_nums):
    answer = []
    zero_count = lottos.count(0)  # 0의 개수
    count = sum([1 for n in lottos if n in win_nums])  # 맞힌 수

    # 최고 순위 계산
    high = 1 if zero_count + count <= 1 else zero_count + count
    answer.append(7 - high)

    # 최저 순위 계산
    low = 1 if count <= 0 else count
    answer.append(7 - low)
    return answer

if __name__ == "__main__":
    solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])
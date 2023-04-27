for _ in range(int(input())):
    employs = set()
    mans = {}
    for i in range(int(input())):
        m = input()
        em = []
        for _ in range(int(input())):
            em.append(input())
        
        employs.add(m)
        for e in em: employs.add(e)

        mans[m] = em

    employs = sorted(list(employs))
    
    

    for em in employs:
        heir = []

        while True:
            heir.append(em)
            tem = ''
            for a, b in mans.items():
                if em in b:
                    tem = a;
                    

            if len(tem) == 0: break
            else: em = tem

        print('/'.join(heir))


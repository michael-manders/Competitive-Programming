def unencrypt_payload(payload, wordlist):
    for word in wordlist:
        # Use XOR operation to unencrypt the payload
        result = ''.join(chr(ord(a) ^ ord(b)) for a, b in zip(payload, word))
        if result.isprintable():
            return result
    return None

payload = "Y9q4Nw"
wordlist = open("rockyou.txt", "r", errors="ignore").readlines()
wordlist = [i.strip() for i in wordlist]
result = unencrypt_payload(payload, wordlist)

if result:
    print(f"The unencrypted payload is: {result}")
else:
    print("Unable to unencrypt the payload")
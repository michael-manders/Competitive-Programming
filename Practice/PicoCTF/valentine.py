import subprocess

ip = "0.cloud.chals.io"
port = 34293
for i in range(10000):
    # run nc command
    p = subprocess.Popen(["nc", ip, str(port)], stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    # send i as input
    p.stdin.write(str(i))
    # get output
    output = p.stdout.read()
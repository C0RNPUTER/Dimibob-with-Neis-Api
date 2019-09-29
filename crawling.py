from dimibob import Dimibob
from datetime import datetime
import os

pagenums = (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
if not os.path.isdir("bob"):
    os.mkdir("bob")
os.chdir(os.getcwd() + '/bob')
for pagenum in pagenums:
    current_year = datetime.now().year
    temp = Dimibob(year=current_year).fetch(page=1)[pagenum]
    tmp = str(temp)
    f = open(tmp[tmp.find("date")+8:tmp.find("date")+18]+".json", 'w', encoding='utf8')
    for t in tmp:
        if t == ",":
            f.write("\n")
        else:
            f.write(t)
    f.close()

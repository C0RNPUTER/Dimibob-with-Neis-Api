# Dimibob-with-Neis-Api
KoreaDigitalMediaHighSchool meal provider. using Dimibob(Python) and Neis-Api(Java).
*****

Dimibob[https://github.com/ChalkPE/dimibob-py]

Neis-Api[https://github.com/agemor/neis-api]

*****
## 개요
기존의 dimibob은 학교급식실 사이트를 파싱하는 형식이어서 급식실에 급식이 올라오지 않으면 파싱할 수가 없었음. 그래서 Neis-Api로 나이스 파싱한 결과물로 한달치 급식을 받아 놓고 dimibob으로 올라온 최신 자료로 업데이트하는 형식으로 만들었음. 결과물은 json파일로 dimibob 아웃풋 형식과 동일하게 나옴.
*****
## 사용법
dimibob실행 방식으로 pip install dimibob하여 dimibob을 실행하고, Neis-Api사용 방식대로 Neis-Api 적용시켜 사용. 결과물은 /bob폴더를 생성하여 그 안에 저장됨.

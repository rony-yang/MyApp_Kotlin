# MyApp_Kotlin


**1. 개발 목표** : Kotlin 예제 실습

**2. 메인 사진**

![main2](https://user-images.githubusercontent.com/116271236/213707080-f5e17f1e-0997-4672-8c71-4b80c2fcdfd8.png)

**3. URL 주소** : 별도 없음

**4. 작업기간** : 22. 11월 ~ 12월

**5. 사용 기술**

- 언어 : Kotlin, Java

- 프로그램 : Android Studio

**6. 주요기능**

- 주요 예제 : 계산기 앱 / 갤러리 보기 앱 / 사진에 투표하고 결과보기 앱 등

**7. Advanced Feature**

라디오버튼을 클릭하면 새로운 Activity를 실행하기 위해서 intent를 생성하고 호출하는 기능입니다.

```kotlin
btnNewActivity.setOnClickListener {
   when (radioGroup1.checkedRadioButtonId) {
      R.id.radioBtnSecond -> {
         var intent = Intent(applicationContext, SecondActivity::class.java)
         startActivity(intent)
      }
      R.id.radioBtnThird -> {
         var intent = Intent(applicationContext, ThirdActivity::class.java)
         startActivity(intent)
      }
      else -> Toast.makeText(applicationContext, 
         "액티비티를 먼저 선택하세요", Toast.LENGTH_SHORT).show()
   }
}

  ```
  
**8. 개선사항**

- 각종 기능들을 통합한 앱 개발 예정

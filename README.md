## cashpay_ifreame
 library to add payments Cash E-wallet to your application.

[![](https://jitpack.io/v/Tamkeen-Developer/cashpay_iframe.svg)](https://jitpack.io/#Tamkeen-Developer/cashpay_iframe)

## Platform Support

| Android |
| :-----: |

## Getting Started

Before you start, create an APIs with the payment providers and follow the setup instructions:
https://documenter.getpostman.com/view/29850098/2s9YXcd5Fd

### Download
Add it in your root build.gradle at the end of repositories:
```groovy
 mavenCentral()
 maven { url 'https://jitpack.io' }
```
Add it in your app build.gradle at the dependency:
```groovy
 implementation 'com.github.Tamkeen-Developer:cashpay_iframe:1.0'
```
### Usage
-Create Clase and pass variables 


```java
CashPay pay=CashPay.getInstance(iframeURL,this);
pay.show(getSupportFragmentManager(),"pay");
```

- iframeURL returned from server Response CreateOrder.
  
- make Activity implements OnReply method.

```java
//Function callback after payment done
@Override
    public void onNeedToCheck() {
       //important use CheckOrderStatus api on your server to check order status.
    }

//Function callback when customer cancel payment
@Override
    public void onCancel() {

    }
```




### License
<pre>
Copyright 2023 Financial Tamkeen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>

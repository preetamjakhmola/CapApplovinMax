# cap-applovin-max

AppLovin MAX Cordova Plugin for Android.

## Install

```bash
npm install cap-applovin-max
npx cap sync
```

## API

<docgen-index>

* [`initialize(...)`](#initialize)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initialize(...)

```typescript
initialize(options: AdOptions) => Promise<void>
```

| Param         | Type                                            |
| ------------- | ----------------------------------------------- |
| **`options`** | <code><a href="#adoptions">AdOptions</a></code> |

--------------------


### Interfaces


#### AdOptions

| Prop            | Type                 | Description                                                                                                                                  | Default            | Since |
| --------------- | -------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- | ------------------ | ----- |
| **`adId`**      | <code>string</code>  | The ad unit ID that you want to request                                                                                                      |                    | 1.1.2 |
| **`isTesting`** | <code>boolean</code> | You can use test mode of ad.                                                                                                                 | <code>false</code> | 1.1.2 |
| **`margin`**    | <code>number</code>  | Margin Banner. Default is 0px; If position is BOTTOM_CENTER, margin is be margin-bottom. If position is TOP_CENTER, margin is be margin-top. | <code>0</code>     | 1.1.2 |
| **`npa`**       | <code>boolean</code> | The default behavior of the Google Mobile Ads SDK is to serve personalized ads. Set this to true to request Non-Personalized Ads             | <code>false</code> | 1.2.0 |

</docgen-api>

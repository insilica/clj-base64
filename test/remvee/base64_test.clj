(ns remvee.base64-test
  (:require [remvee.base64 :as base64]
            [clojure.test :refer [is deftest]]))

(def test-data
  [["t" "dA=="]
   ["te" "dGU="]
   ["tes" "dGVz"]
   ["test" "dGVzdA=="]
   ["testi" "dGVzdGk="]
   ["testin" "dGVzdGlu"]
   ["testing" "dGVzdGluZw=="]
   ["Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." "TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2ljaW5nIGVsaXQsIHNlZCBkbyBlaXVzbW9kIHRlbXBvciBpbmNpZGlkdW50IHV0IGxhYm9yZSBldCBkb2xvcmUgbWFnbmEgYWxpcXVhLiBVdCBlbmltIGFkIG1pbmltIHZlbmlhbSwgcXVpcyBub3N0cnVkIGV4ZXJjaXRhdGlvbiB1bGxhbWNvIGxhYm9yaXMgbmlzaSB1dCBhbGlxdWlwIGV4IGVhIGNvbW1vZG8gY29uc2VxdWF0LiBEdWlzIGF1dGUgaXJ1cmUgZG9sb3IgaW4gcmVwcmVoZW5kZXJpdCBpbiB2b2x1cHRhdGUgdmVsaXQgZXNzZSBjaWxsdW0gZG9sb3JlIGV1IGZ1Z2lhdCBudWxsYSBwYXJpYXR1ci4gRXhjZXB0ZXVyIHNpbnQgb2NjYWVjYXQgY3VwaWRhdGF0IG5vbiBwcm9pZGVudCwgc3VudCBpbiBjdWxwYSBxdWkgb2ZmaWNpYSBkZXNlcnVudCBtb2xsaXQgYW5pbSBpZCBlc3QgbGFib3J1bS4="]])

(defn encode-str [s]
  (apply str (base64/encode (.getBytes s))))

(defn decode-str [s]
  (String. (byte-array (base64/decode s))))

(deftest test-encode
  (doseq [[input expected] test-data]
    (is (= expected (encode-str input)))))

(deftest test-decode
  (doseq [[expected input] test-data]
    (is (= expected (decode-str input)))))

(deftest test-encodings
  (is (= "I 💟 søup"
         (decode-str (encode-str "I 💟 søup")))))

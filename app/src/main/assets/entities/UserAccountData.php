<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;

use DateTime;
use vanci_core\libs\Globals;

class UserAccountData
{


     /**
      * @var int
      */
     public $userAccountId = -1;  //:int
     /**
      * @var string
      */
     public $userDeiveUuid = ''; //
     /**
      * @var string
      */
     public $userFullName = '';
     /**
      * @var string
      */
     public $userEmail = '';
     /**
      * @var string
      */
     public $userPassword = '';
     /**
      * @var string
      */
     public $userImageUrl = '';
     /**
      * @var StatusData
      */
     public $userSessionStatus;
     /**
      * @var StatusData
      */
     public $userStatusData;
     /**
      * @var DateTime
      */
     public $userAccountCreationDatetime;
     /**
      * @var DateTime
      */
     public $userAccountLastModificationDatetime;
     /**
      * @var int
      */
     public $userLoginTries = 0;
     /**
      * @var string
      */
     public $userBirthday = '';
     /**
      * @var string
      */
     public $userSessionToken = '';

     public function getUserBirthdayFormated()
     {

          $newDate = date_format(date_create($this->userBirthday), "Y-m-d");

          return strval($newDate);
     }
     function __construct()
     {
          //          $this->userStatusData = new StatusData();

          // $this->userSessionStatus = new StatusData();
          $this->userAccountId = -1;
          $this->userDeiveUuid = '';
          //$this->userAccountLastLogin = date("l");

          $imageUrl = Common::getImageUrl(0, "user_account", 1);

          $this->userImageUrl = $imageUrl;





     }
     public static function getInstance($object): UserAccountData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserAccountData");
          return $object;
     }

     public function setUserImageUrl($url)
     {
          $globals = Globals::build();

          if ($url == "" || strlen($url) < 3) {

               // $imageUrl = $globals->serverResourcesUrl . 'images/user_account/0.png';
               $imageUrl = Common::getImageUrl(0, "user_account", 1);

               $this->userImageUrl = $imageUrl;
          } else {


               $this->userImageUrl = $url;
          }
     }
}

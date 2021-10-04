<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_account_action.sql

 */

class UserAccountActionData
{


     /**
      * @var int
      */
     public $userAccountActionId;

     /**
      * @var string
      */
     public $userAccountActionName;
/**
      * @var string
      */

     public $imageUrl;
     
     public static function getInstance($object): UserAccountActionData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserAccountActionData");
          return $object;
     }
     function __construct()
     {
          $globals=Globals::build();

          $this->imageUrl = $globals->resourcesPath . 'images/user_account_action/0.png';

     }
}

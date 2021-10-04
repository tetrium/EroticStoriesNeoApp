<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_category.sql

 */

class UserStatisticsData
{



     /**
      * @var int
      */
     public $userStatisticsId;

     /**
      * @var string
      */
     public $currentConversationId;


     /**
      * @var string
      */

     public $totalCorrectWordPronunciations;

     /**
      * @var string
      */
     public $totalIncorrectWordPronunciations;

     /**
      * @var string
      */
     public $totalPronunciationWordsAverage;

     /**
      * @var string
      */
     public $pronunciationAverageDirection;
     /**
      * @var string
      */
     public $userEnglishLevel;
     /**
      * @var string
      */
     public $userLevel;

     /**
      * @var string
      */
     public $userExperiencePoints;
     /**
      * @var string
      */
     public $userTotalCoinsEarned;
     /**
      * @var string
      */
     public $userRank;

     public static function getInstance($object): UserStatisticsData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserStatisticsData");
          return $object;
     }
     function __construct()
     {
     }
}

<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;

use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation.sql

 */

class ConversationData
{


     /**
      * @var int
      */
     public $conversationId;

     /**
      * @var string
      */
     public $conversationTitle;
     /**
      * @var string
      */
     public $conversationDescription;
   
     /**
      * @var float
      */
     public $conversationRate;
    
     /**
      * @var int
      */
     public $conversationCategoryId;
   

     /**
      * @var int
      */
     public $englishLevelId;
    
     /**
      * @var int
      */
     public $conversationTotalChapters;


     /**
      * @var int
      */
     public $conversationTotalSentences;

     /**
      * @var int
      */
     public $conversationTotalReaders;

     /**
      * @var int
      */
     public $conversationTotalUserFavorites;

  



     /**
      * @var Date
      */
     public $conversationLastModificationDatetime;
     /**
      * @var string
      */

     public $conversationImage64;

     /**
      * @var string
      */
     public $conversationImageUrl;









     /**
      * @var ConversationTagData[]
      */
     public $conversationTags;
   
     /**
      * @var ConversationCategoryData
      */
     public $conversationCategory;
     /**
      * @var EnglishLevelData
      */
     public $englishLevel;
    
     

     public function getConversationWrittenDateFormated()
     {

          if ($this->conversationWrittenDate == "") {
               $this->conversationWrittenDate = "1990-01-01 12:12:12";
          }

          $newDate = date_format(date_create($this->conversationWrittenDate), "Y-m-d");

          return strval($newDate);
     }
     public static function getInstance($object): ConversationData
     {

          if ($object != null)
               $object = Common::stdClassToClass($object, "vanci_core\\entities\\ConversationData");
          else
               $object = new ConversationData(-1);
          return $object;
     }
     function __construct(int $conversationId = -1)
     {
          $globals = Globals::build();
          $this->conversationCategory = null;
          $this->englishLevel = null;


          if ($conversationId > 0) {
               $imagePath = Common::getImagePath($conversationId, "conversation", 1);
               $this->conversationImage64 = '';

               if (!file_exists($imagePath)) {
                    $imageUrl = Common::getImageUrl(0, "conversation", 1); // $globals->serverResourcesUrl . 'images/conversation/0.png';
               } else {
                    $imageUrl = Common::getImageUrl($conversationId, "conversation", 1);
                    //$imageUrl = $globals->serverResourcesUrl . 'images/conversation/' . $conversationId . '.png';
               }


               $this->conversationImageUrl = $imageUrl;
          } else {

               $this->conversationId = -1;
               $this->conversationTitle = '';
               $this->conversationImage64 = '';
               //  $imageUrl = $globals->serverResourcesUrl . 'images/conversation/0.png';
               $imageUrl = Common::getImageUrl(0, "conversation", 0);
               $this->conversationImageUrl = $imageUrl;
          }
     }
}

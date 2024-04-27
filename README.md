![image](https://github.com/sudhir-takale/Troop-Training-Simulation/assets/93988135/cf687ce1-3297-4588-9186-1ab06e16c104)

# Problem Statement: (Troop training simulation is inspired from Clash of Clans games.)

As a gaming programmer you have to create a simulation software using which gamers can train army troops. Definition and
details of the simulation is as follows
Army Troops:  
There are two kinds of troops Archers and Barbarians. Each trooper(archer/barbarian)
<br /><br />

| Trooper                       | Training Time (seconds) | Training Cost (magic potions) |
|:------------------------------|:-----------------------:|:-----------------------------:|
| Barbarian(weapon: sword)      |            3            |              10               |
| Archer(weapon: Bow and Arrow) |            6            |              20               |

### Barracks: where each trooper gets trained.

- Only one trooper can be trained at a given point of time.
- The maximum seat capacity of a barracks is 10.
- Others have to wait to outside the barracks
- Barracks can have mix of troopers: e.g.: 5 Archers and 5 Barbarians or 4 Archers and 6 Barbarians or 10 Archers or 10
  Barbarians

### Army Camp: where troops assemble after training.

## Scenario 1: Simulate the training and train barbarians and/or archers.

- As a gamer
- i should be able to input no.of barbarians and/or archers i would like to train.
- i should be able to see how many troops are trained and available in troop camp after training completes. Example
  input/output:

### troop-training > start-training

1. train troops.
2. view troop camp

- What do you want to do ? 1 <br />

1. Archer
2. Barbarian <br />
   which troop u want to train ? 1 <br />
   how many archers you want to train ? 10 <br />
   training...<br />

- training complete. troops are available in the troop camp. <br />

1. train troops. <br />
2. view troop camp  <br />

- What do you want to do ? 2 <br />
- Archers: 10 <br />
- Barbarian: 0 <br />

1. train troops. <br />
2. view troop camp <br />
   What do you want to do ? 1 <br />

---------------------------------------------------------------------------

ProjectName : Troop Training Simulator -
Domain: Training Simulation

### Domain

    -model
        - Troop   - parent class of trooper
        - Barrack
            - list <Troop> or Queue
                    - conditions
                      - max capacity 10
                      - wait outside barracks
        - Army Camp
                - no.of troops          
    - service
        - TroopTrainer - here troops are trained

### controller

- TroopController - used to create troops of type archers or babarians
- BarrackController - used to add and train the troopers
- ArmyCampController - here the trained troops are assembled

### Service

- TroopService - create the troopers
    - create troopers
    - getTroopers

- BarrackService - to train the troopers
    - add troops to barracks
    - send to training

- ArmyCampService - here the troopers are assembled after training is completed
    - addtroops
    - updateTrooperCount
    - showAvailableTroops
    -

### Repository

- TroopRepository
    - addtroops - to add new troops in repository
    - getTroops - get all availableTroops to train

- BarrackRepository - to store the troops for training in queue
    - addTroopsToBarrack - to add troops from trooprepository
    - getTroops for training

- ArmyCampRepository - to store the troopers after training
    - add new Troops
    - get available troops 



#### Flow

- create the trooper 
- when user request trooper of any and count
- barrack service will get troops of requested type from the troopservice
- barrack will put them in queue 
- according to number troopers are trained 
- barrack service will call to Domain service 
  - troopers will trained
- after that once troops are trained then assembled in armycamp
- then user can view how many troopers are available


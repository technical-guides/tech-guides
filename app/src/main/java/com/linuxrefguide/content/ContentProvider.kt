package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

object ContentProvider {
    fun getWelcomeMessage(): String = """
🐧 Welcome to the Linux Ref. Guide! 🐧

This interactive tutorial will guide you through essential Linux concepts,
from basic file operations to advanced system administration.

📖 What you'll learn:

• Basic Topics: File system navigation, file operations, viewing files, permissions
• Intermediate Topics: Process management, system monitoring, shell scripting, storage
• Advanced Topics: Kernel management, networking, security, virtualization

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Linux journey! 🎓
    """.trimIndent()

    fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Linux Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Linux fundamentals.

⚡ Intermediate Topics
Master system administration skills.

🚀 Advanced Topics
Dive into expert-level Linux mastery.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

📁 File Commands
Learn essential file operations like creating, copying, moving, and deleting files.
Commands: touch, cp, mv, rm, mkdir

📂 Directory Navigation
Master navigating the Linux file system and understanding directory structures.
Commands: cd, ls, pwd, find, tree

👁️ File Viewing
Discover different ways to view and examine file contents.
Commands: cat, less, more, head, tail, grep

🔒 Permissions
Understand Linux file permissions and ownership concepts.
Commands: chmod, chown, chgrp, umask
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Linux skills:

⚙️ Process Management
Master controlling and monitoring system processes, job control, and systemd.
Commands: ps, kill, killall, top, htop, systemctl, jobs, nohup

📊 System Monitoring
Learn performance analysis, resource monitoring, and log management.
Tools: iostat, vmstat, sar, journalctl, dmesg, free, df

💾 Storage & Filesystems
Advanced disk management, LVM, RAID, and filesystem optimization.
Topics: LVM, RAID, filesystem tuning, quotas, ACLs

💻 Shell Scripting
Write advanced bash scripts with functions, loops, and error handling.
Topics: Variables, functions, conditionals, loops, parameter expansion

👥 User Management
Understand user accounts, groups, sudo configuration, and PAM.
Commands: useradd, usermod, passwd, sudo, groups, id

📦 Package Management
Learn software installation, dependency management, and repository configuration.
Tools: apt, yum, dnf, snap, flatpak, rpm, dpkg

🌐 Network Basics
Basic network configuration, troubleshooting, and monitoring.
Commands: ip, netstat, ss, ping, traceroute, wget, curl
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Linux knowledge:

🔧 Kernel & Modules
Low-level system management, kernel compilation, and module development.
Commands: lsmod, modprobe, rmmod, modinfo, dkms, make menuconfig

🌐 Advanced Networking
Network security, traffic shaping, VPNs, and complex configurations.
Tools: iptables, tc, OpenVPN, WireGuard, netfilter, bridge-utils

🔐 Security Hardening
System security, mandatory access controls, and vulnerability mitigation.
Topics: SELinux, AppArmor, audit system, secure boot, hardening guides

🐳 Virtualization
Container technologies, orchestration, and virtual machine management.
Tools: Docker, Kubernetes, LXC, KVM, QEMU, libvirt

🏗️ High Availability
Clustering, load balancing, and fault-tolerant system design.
Tools: Pacemaker, Corosync, HAProxy, keepalived, DRBD

🔍 System Internals
Deep understanding of kernel internals, memory management, and debugging.
Topics: /proc, /sys, system calls, memory mapping, kernel debugging

⚡ Performance Tuning
System optimization, profiling, and advanced performance analysis.
Tools: perf, strace, ltrace, valgrind, SystemTap, eBPF
            """.trimIndent()
        }
    }

    fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basic" -> when (id) {
                "files" -> """
📁 File Commands - Basic File Operations

Essential commands for creating, copying, moving, and deleting files:

🆕 Creating Files and Directories:
• touch filename.txt - Create an empty file
• touch file1.txt file2.txt file3.txt - Create multiple files
• mkdir directory_name - Create a new directory
• mkdir -p path/to/nested/dirs - Create nested directories
• mkdir dir1 dir2 dir3 - Create multiple directories

📋 Copying Files and Directories:
• cp source.txt destination.txt - Copy a file
• cp source.txt /path/to/directory/ - Copy file to directory
• cp -r source_dir/ dest_dir/ - Copy directory recursively
• cp -i source.txt dest.txt - Interactive copy (ask before overwrite)
• cp -v source.txt dest.txt - Verbose copy (show what's happening)
• cp -p source.txt dest.txt - Preserve timestamps and permissions

🚚 Moving and Renaming:
• mv old_name.txt new_name.txt - Rename a file
• mv file.txt /path/to/directory/ - Move file to directory
• mv dir1/ /path/to/new/location/ - Move directory
• mv -i source.txt dest.txt - Interactive move (ask before overwrite)
• mv *.txt /backup/ - Move all .txt files to backup directory

🗑️ Removing Files and Directories:
• rm filename.txt - Remove a file
• rm file1.txt file2.txt - Remove multiple files
• rm -i filename.txt - Remove with confirmation prompt
• rm -r directory/ - Remove directory recursively
• rm -rf directory/ - Force remove directory (be careful!)
• rmdir empty_directory - Remove empty directory only

🔍 Useful File Operations:
• ls -la - List files with detailed information
• file filename.txt - Determine file type
• stat filename.txt - Show detailed file statistics
• wc filename.txt - Count lines, words, and characters
• du -h filename.txt - Show file size in human-readable format
• df -h - Show disk space usage

⚠️ Safety Tips:
• Always use -i flag when removing important files
• Double-check paths before using rm -r or rm -rf
• Use ls to verify file locations before operations
• Test commands on unimportant files first
• Consider using trash-cli instead of rm for safety

💡 Pro Tips:
• Use Tab completion to avoid typos in filenames
• Wildcards: * (any characters), ? (single character)
• Use quotes for filenames with spaces: "my file.txt"
• Combine commands: mkdir project && cd project

[Interactive exercises and quizzes coming soon!]

Press Escape to return to Basic Topics menu.
        """.trimIndent()
                "nav" -> """
📂 Directory Navigation - Moving Around the File System

Master the art of navigating Linux directories and file system:

🧭 Basic Navigation Commands:
• pwd - Print working directory (where am I?)
• cd directory_name - Change to a specific directory
• cd .. - Move up one directory level
• cd ../.. - Move up two directory levels
• cd ~ - Go to home directory
• cd / - Go to root directory
• cd - - Go to previous directory

📋 Listing Directory Contents:
• ls - List files and directories in current location
• ls -l - Long format listing with permissions and details
• ls -la - List all files including hidden ones (starting with .)
• ls -lh - List with human-readable file sizes
• ls -lt - Sort by modification time (newest first)
• ls -lS - Sort by file size (largest first)
• ls -R - Recursive listing of subdirectories

🔍 Finding Files and Directories:
• find /path -name "filename" - Search for files by name
• find . -name "*.txt" - Find all .txt files in current directory
• find /home -type d -name "Documents" - Find directories named Documents
• find . -size +100M - Find files larger than 100MB
• find . -mtime -7 - Find files modified in last 7 days
• locate filename - Quick file search using database
• which command_name - Find location of a command
• whereis command_name - Find binary, source, and manual pages

📁 Understanding Directory Structure:
• / - Root directory (top of filesystem)
• /home - User home directories
• /etc - System configuration files
• /var - Variable data (logs, spool files)
• /tmp - Temporary files
• /usr - User programs and data
• /bin - Essential binaries
• /sbin - System binaries
• /dev - Device files
• /proc - Kernel and process information

💡 Navigation Tips:
• Use cd ~username to access another user’s home directory
• Combine ls with grep: ls -l | grep .txt
• Use tree -L 2 for a visual directory structure
• Update locate database: sudo updatedb
• Use pushd/popd for directory stack navigation

⚠️ Safety Tips:
• Verify paths with pwd before changing directories
• Avoid running commands in / or /root as non-root
• Be cautious with find -exec (test with -print first)
• Check permissions with ls -l before accessing
• Use absolute paths (/path/to/dir) for scripts

[Interactive exercises and quizzes coming soon!]

Press Escape to return to Basic Topics menu.
        """.trimIndent()
                "view" -> """
👁️ File Viewing - Examining File Contents

Learn different ways to view and examine files safely and effectively:

📖 Basic File Viewing:
• cat filename.txt - Display entire file contents
• cat file1.txt file2.txt - Display multiple files
• cat -n filename.txt - Show line numbers
• tac filename.txt - Display file in reverse order
• less filename.txt - View file page by page (recommended)
• more filename.txt - Similar to less, but simpler

🔍 Partial File Viewing:
• head filename.txt - Show first 10 lines
• head -n 20 file.txt - Show first 20 lines
• head -c 100 file.txt - Show first 100 characters
• tail filename.txt - Show last 10 lines
• tail -n 5 file.txt - Show last 5 lines
• tail -f logfile.txt - Follow file changes in real-time
• tail -F logfile.txt - Follow file even if it’s rotated

🔎 Searching File Contents:
• grep pattern filename.txt - Search for pattern in file
• grep -i pattern filename.txt - Case-insensitive search
• grep -r pattern /path - Recursive search in directory
• grep -n pattern filename.txt - Show line numbers
• grep -v pattern filename.txt - Show lines not matching pattern
• grep -c pattern filename.txt - Count matching lines
• egrep "pattern1|pattern2" file.txt - Search multiple patterns
• fgrep "literal string" file.txt - Literal string search

📄 Advanced File Viewing:
• view filename.txt - Open file in read-only vi/vim
• nano filename.txt - Open file in nano editor (read-only with Ctrl+R)
• vim -R filename.txt - Open file in read-only mode
• less +F filename.txt - Start less in follow mode (like tail -f)
• cut -d',' -f1 file.csv - Extract first column from CSV
• sort filename.txt - Sort file contents
• uniq filename.txt - Remove duplicate lines
• wc -l filename.txt - Count lines in file

🔧 File Type and Metadata:
• file filename - Determine file type
• stat filename.txt - Show file metadata (size, permissions, timestamps)
• xxd filename - Display file in hexadecimal
• od -tx4 filename - Display file in octal or hex
• strings filename - Extract printable strings from binary files

💡 Tips for Effective Viewing:
• Use less for large files (faster than cat)
• Press q to quit less or more
• In less: /pattern to search, n for next match, N for previous
• Combine with pipes: cat file.txt | grep pattern | less
• Use -F with tail for log files that rotate
• Save output: grep pattern file.txt > output.txt
• Use Tab completion to avoid typos in filenames

⚠️ Safety Tips:
• Avoid cat for binary files (use strings or file instead)
• Use less or more for large files to avoid terminal overload
• Double-check file paths before viewing
• Be cautious with sensitive files (e.g., /etc/passwd)

[Interactive file viewing exercises coming soon!]

Press Escape to return to Basic Topics menu.
        """.trimIndent()
                "perms" -> """
🔒 Permissions - File and Directory Access Control

Understand Linux file permissions and ownership concepts:

🔐 Understanding Permissions:
• ls -l - Show permissions, owner, and group
• Permissions format: rwxr-xr-x (owner, group, others)
• r = read (4), w = write (2), x = execute (1)
• Example: rwxr-xr-x = 755 (owner: 7, group: 5, others: 5)
• - = regular file, d = directory, l = symbolic link

👤 Changing File Ownership:
• chown username filename.txt - Change file owner
• chown username:groupname filename.txt - Change owner and group
• chown -R username:groupname directory/ - Recursive change
• chgrp groupname filename.txt - Change group only
• chgrp -R groupname directory/ - Recursive group change
• chown -h username link - Change symbolic link ownership

🔧 Modifying Permissions:
• chmod 755 filename - Set permissions numerically (rwxr-xr-x)
• chmod u+rwx,g+rx,o+rx filename - Set permissions symbolically
• chmod -R 644 directory/ - Recursive permissions change
• chmod u+x script.sh - Add execute permission for owner
• chmod g-w filename - Remove write for group
• chmod o-rwx filename - Remove all permissions for others

📌 Special Permissions:
• chmod u+s filename - Set SUID (run as owner)
• chmod g+s directory - Set SGID (inherit group for new files)
• chmod +t directory - Set sticky bit (only owner can delete)
• Example: rwxr-sr-t = SUID and sticky bit set
• ls -l /usr/bin/passwd - See SUID in action (rwsr-xr-x)

🎭 Default Permissions with umask:
• umask - Show current umask value
• umask 022 - Set umask (new files: 644, directories: 755)
• umask 027 - Restrict others (new files: 640, directories: 750)
• umask -S - Show umask symbolically
• echo "umask 022" >> ~/.bashrc - Set permanent umask

🔍 Viewing Permissions:
• ls -l filename - Show permissions and ownership
• stat filename - Detailed permission and metadata
• getfacl filename - Show Access Control Lists (if used)
• namei -f /path/to/file - Show permissions along path
• lsattr filename - List extended attributes

💡 Permissions Tips:
• Use numeric mode for quick changes (e.g., 755, 644)
• Symbolic mode is more readable: u=user, g=group, o=others
• SUID/SGID useful for scripts and shared directories
• Sticky bit common for /tmp (drwxrwxrwt)
• Always verify with ls -l after changes

⚠️ Safety Tips:
• Avoid 777 permissions unless absolutely necessary
• Be cautious with SUID/SGID (security risks)
• Test permission changes on non-critical files
• Use chown/chmod -R carefully to avoid affecting unintended files
• Backup important files before modifying permissions

[Interactive permissions exercises coming soon!]

Press Escape to return to Basic Topics menu.
        """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "process" -> """
⚙️ Process Management - Advanced Process Control

Master the art of managing system processes and services:

🔍 Process Monitoring:
• ps aux - Show all running processes with detailed info
• ps -ef - Alternative process listing format  
• pstree - Display processes in tree format
• top - Real-time process monitor (interactive)
• htop - Enhanced version of top (if installed)
• pgrep pattern - Find processes by name pattern

🎯 Process Control:
• kill PID - Terminate process by ID
• kill -9 PID - Force kill process (SIGKILL)
• kill -15 PID - Graceful termination (SIGTERM)
• killall process_name - Kill all processes by name
• pkill pattern - Kill processes matching pattern

⚡ Job Control:
• command & - Run command in background
• jobs - List active jobs
• fg %1 - Bring job 1 to foreground
• bg %1 - Send job 1 to background
• nohup command & - Run command immune to hangups
• disown - Remove job from shell's job table

🔧 systemd Service Management:
• systemctl status service - Check service status
• systemctl start service - Start a service
• systemctl stop service - Stop a service
• systemctl restart service - Restart a service
• systemctl enable service - Enable service at boot
• systemctl disable service - Disable service at boot
• systemctl daemon-reload - Reload systemd configuration

📊 Resource Management:
• nice -n 10 command - Run with lower priority
• renice 5 PID - Change process priority
• ionice -c 2 -n 5 PID - Set I/O priority
• ulimit -a - Show resource limits
• cgroups - Control groups for resource isolation

💡 Tips for Process Management:
• Use htop for a user-friendly process overview
• Combine ps with grep: ps aux | grep process_name
• Check systemctl status for detailed service logs
• Use nohup for long-running background tasks
• Monitor resource usage with top or htop

⚠️ Safety Tips:
• Avoid SIGKILL (-9) unless necessary
• Verify PIDs before killing processes
• Test systemctl commands on non-critical services
• Backup service files before modifying
• Use cgroups for fine-grained resource control

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "monitor" -> """
📊 System Monitoring - Performance Analysis & Diagnostics

Learn to monitor system health and troubleshoot performance issues:

🏃 CPU & Load Monitoring:
• uptime - System load averages and uptime
• lscpu - Display CPU architecture information
• vmstat 2 - Virtual memory statistics every 2 seconds
• iostat 2 - I/O and CPU statistics
• sar -u 2 5 - CPU utilization every 2 seconds, 5 times
• mpstat - Multi-processor statistics

💾 Memory Monitoring:
• free -h - Memory usage in human-readable format
• cat /proc/meminfo - Detailed memory information
• vmstat -s - Virtual memory statistics summary
• slabtop - Kernel slab cache information
• pmap PID - Memory map of a process

💿 Disk I/O Monitoring:
• iotop - Real-time I/O usage by process (requires root)
• iostat -x 2 - Extended I/O statistics
• lsblk - List block devices
• df -h - Disk space usage
• du -sh /path/* - Directory sizes
• fuser /path/file - Show processes using a file

🌐 Network Monitoring:
• ss -tuln - Show listening ports
• netstat -i - Network interface statistics
• iftop - Real-time network usage by connection
• nethogs - Network usage by process
• tcpdump -i eth0 - Packet capture on interface

📝 Log Analysis:
• journalctl - View systemd logs
• journalctl -f - Follow log in real-time
• journalctl -u service - Logs for specific service
• dmesg - Kernel ring buffer messages
• dmesg -w - Follow kernel messages
• tail -f /var/log/syslog - Follow system logs

💡 Monitoring Tips:
• Use htop or glances for a visual overview
• Combine journalctl with grep: journalctl | grep error
• Save iostat/vmstat output: iostat 2 > stats.txt
• Use watch for periodic updates: watch -n 2 df -h
• Check /var/log for specific application logs

⚠️ Safety Tips:
• Run iotop and similar tools as root carefully
• Avoid overloading system with frequent monitoring
• Backup logs before clearing or rotating
• Verify file paths in /var/log
• Use journalctl filters to avoid log overload

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "storage" -> """
💾 Storage & Filesystems - Advanced Disk Management

Learn advanced disk management, LVM, RAID, and filesystem optimization:

💿 Disk Management:
• fdisk -l - List disk partitions
• parted /dev/sda - Interactive partition editor
• lsblk - List block devices and mount points
• blkid - Show device UUIDs and types
• df -h - Disk space usage in human-readable format
• du -sh /path - Directory size summary

📁 Filesystem Operations:
• mkfs.ext4 /dev/sda1 - Create ext4 filesystem
• fsck /dev/sda1 - Check and repair filesystem
• tune2fs -l /dev/sda1 - Show filesystem parameters
• tune2fs -m 2 /dev/sda1 - Set reserved block percentage
• mount /dev/sda1 /mnt - Mount filesystem
• umount /mnt - Unmount filesystem

🔗 Logical Volume Manager (LVM):
• pvcreate /dev/sda1 - Initialize physical volume
• vgcreate vg_name /dev/sda1 - Create volume group
• lvcreate -L 10G vg_name - Create logical volume
• lvextend -L +5G /dev/vg_name/lv_name - Extend logical volume
• lvreduce -L -5G /dev/vg_name/lv_name - Reduce logical volume
• vgdisplay - Show volume group details

🛡️ RAID Management:
• mdadm --create /dev/md0 --level=1 --raid-devices=2 /dev/sda1 /dev/sdb1 - Create RAID array
• mdadm --detail /dev/md0 - Show RAID details
• mdadm --stop /dev/md0 - Stop RAID array
• cat /proc/mdstat - Show RAID status
• mdadm --grow /dev/md0 --raid-devices=3 --add /dev/sdc1 - Add disk to RAID

📊 Filesystem Optimization:
• tune2fs -O extents,uninit_bg /dev/sda1 - Enable ext4 features
• e2fsck -f /dev/sda1 - Force filesystem check
• resize2fs /dev/sda1 - Resize filesystem after LVM
• fstrim /mnt - Trim SSD for performance
• hdparm -tT /dev/sda - Test disk performance

🔒 Access Control Lists (ACLs):
• setfacl -m u:user:rwx file - Set ACL for user
• getfacl file - Show ACLs
• setfacl -R -m g:group:r-x directory - Recursive ACL
• setfacl -b file - Remove all ACLs
• mount -o acl /dev/sda1 /mnt - Enable ACL support

💡 Storage Tips:
• Use lsblk to visualize device hierarchy
• Combine LVM with RAID for flexibility
• Test filesystem changes in a VM first
• Monitor disk usage with df and du
• Use fstrim regularly for SSDs

⚠️ Safety Tips:
• Backup data before partitioning or formatting
• Double-check device names (e.g., /dev/sda)
• Test RAID changes on non-critical disks
• Verify mounts before writing to filesystems
• Avoid reducing LVM volumes without backups

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "shell" -> """
💻 Shell Scripting - Automation and Scripting

Write advanced bash scripts with functions, loops, and error handling:

📜 Basic Script Structure:
• #!/bin/bash - Shebang for bash scripts
• echo "Hello, World!" - Print output
• exit 0 - Exit with success status
• exit 1 - Exit with error status
• chmod +x script.sh - Make script executable
• ./script.sh - Run script

🔧 Variables and Parameters:
• variable=value - Set variable
• echo $\variable - Print variable
• $\{variable:-default} - Use default if unset
• $1, $2, ... - Positional parameters
• $# - Number of arguments
• $@ - All arguments as separate words
• "$@" - All arguments as quoted strings

🔄 Control Structures:
• if [ condition ]; then commands; fi - Conditional
• [ "$\var" = "value" ] - String comparison
• [ $\num -eq 10 ] - Numeric comparison
• for i in {1..5}; do echo $\i; done - For loop
• while [ condition ]; do commands; done - While loop
• case $\var in pattern) commands;; esac - Case statement

📡 Input/Output:
• read var - Read user input into variable
• echo "text" > file.txt - Write to file
• echo "text" >> file.txt - Append to file
• command < file.txt - Read input from file
• command | tee file.txt - Write to file and stdout
• command 2> error.log - Redirect stderr

⚙️ Functions:
• function_name() { commands; } - Define function
• function_name arg1 arg2 - Call function
• return 42 - Return value from function
• local var=value - Local variable in function
• declare -f - List defined functions

🔍 Error Handling:
• set -e - Exit on error
• set -u - Exit on unset variables
• trap 'echo Error at line $\LINENO' ERR - Trap errors
• command || { echo "Failed"; exit 1; } - Handle command failure
• test -f file.txt || echo "File not found"

💡 Scripting Tips:
• Use quotes around variables: "$\var"
• Test scripts in a safe environment
• Use shellcheck to lint scripts
• Comment scripts for clarity: # Comment
• Use functions for reusable code

⚠️ Safety Tips:
• Avoid eval for dynamic code
• Validate user input to prevent injection
• Test scripts with dry-run options
• Backup files before overwriting
• Use set -euo pipefail for robust scripts

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "users" -> """
👥 User Management - Accounts and Permissions

Understand user accounts, groups, sudo, and PAM configuration:

👤 User Account Management:
• useradd username - Create a new user
• usermod -aG group username - Add user to group
• userdel -r username - Delete user and home directory
• passwd username - Change user password
• id username - Show user and group IDs
• whoami - Show current user
• w - Show logged-in users

👥 Group Management:
• groupadd groupname - Create a new group
• groupdel groupname - Delete a group
• groups username - List user’s groups
• getent group groupname - Show group details
• gpasswd -a user group - Add user to group
• gpasswd -d user group - Remove user from group

🔐 Sudo Configuration:
• visudo - Edit /etc/sudoers safely
• username ALL=(ALL) ALL - Grant full sudo access
• username ALL=(ALL) NOPASSWD: /bin/ls - Passwordless command
• %groupname ALL=(ALL) ALL - Grant group sudo access
• sudo -u user command - Run command as user
• sudo -l - List sudo privileges

🔧 Password Management:
• passwd -l username - Lock user account
• passwd -u username - Unlock user account
• chage -E 2024-12-31 username - Set account expiry
• chage -l username - Show account aging info
• /etc/shadow - Password storage (hashed)
• pwgen 12 - Generate random password

📜 Pluggable Authentication Modules (PAM):
• cat /etc/pam.d/sshd - SSH PAM configuration
• pam_tally2 - Track login attempts
• pam_limits.so - Set resource limits via PAM
• pam_env.so - Set environment variables
• /etc/security/limits.conf - Resource limits
• authconfig --update - Update PAM configs

💡 User Management Tips:
• Use adduser for interactive user creation
• Check /etc/passwd and /etc/group for details
• Use visudo to avoid syntax errors
• Monitor /var/log/auth.log for login attempts
• Set strong passwords with passwd or pwgen

⚠️ Safety Tips:
• Backup /etc/passwd and /etc/shadow
• Test sudo changes on non-critical users
• Avoid direct edits to /etc/sudoers
• Lock unused accounts with passwd -l
• Restrict sudo to specific commands

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "packages" -> """
📦 Package Management - Software Installation & Management

Learn to manage software on different Linux distributions:

🛠️ APT (Debian/Ubuntu):
• apt update - Update package index
• apt upgrade - Upgrade installed packages
• apt install package_name - Install a package
• apt remove package_name - Remove a package
• apt autoremove - Remove unused dependencies
• apt search keyword - Search for packages
• apt show package_name - Show package details
• apt list --installed - List installed packages

🍴 DNF/YUM (Fedora/Red Hat):
• dnf update - Update package index and upgrade
• dnf install package_name - Install a package
• dnf remove package_name - Remove a package
• dnf search keyword - Search for packages
• dnf info package_name - Show package details
• dnf list installed - List installed packages
• yum update - (Older systems, similar to dnf)
• yum install package_name - Install with YUM

📥 RPM/ DPKG (Low-level):
• rpm -ivh package.rpm - Install RPM package
• rpm -e package_name - Remove RPM package
• rpm -qa - List all installed packages
• rpm -qi package_name - Show package information
• dpkg -i package.deb - Install DEB package
• dpkg -r package_name - Remove DEB package
• dpkg -l - List installed packages
• dpkg -L package_name - List files installed by package

📲 Snap Packages:
• snap install package_name - Install a snap package
• snap remove package_name - Remove a snap package
• snap list - List installed snaps
• snap refresh - Update all snap packages
• snap info package_name - Show snap details
• snap find keyword - Search for snap packages

📥 Flatpak Packages:
• flatpak install flathub app_name - Install from Flathub
• flatpak uninstall app_name - Remove a flatpak app
• flatpak list - List installed flatpaks
• flatpak update - Update all flatpaks
• flatpak search keyword - Search for flatpak apps
• flatpak info app_name - Show app details

🔗 Repository Management:
• add-apt-repository ppa:name - Add PPA (Ubuntu)
• apt edit-sources - Edit /etc/apt/sources.list
• dnf config-manager --add-repo url - Add DNF repository
• yum-config-manager --add-repo url - Add YUM repository
• cat /etc/apt/sources.list - View Debian repositories
• cat /etc/yum.repos.d/*.repo - View Red Hat repositories

🔍 Package Verification & Queries:
• apt-cache depends package_name - Show dependencies
• dnf repoquery --requires package_name - Show dependencies
• rpm -V package_name - Verify package integrity
• dpkg --verify package_name - Verify DEB package
• apt-file search filename - Find package providing file
• dnf provides filename - Find package providing file

💾 Local Package Management:
• dpkg -i package.deb - Install local DEB file
• rpm -Uvh package.rpm - Upgrade/install RPM file
• apt install ./package.deb - Install local DEB with apt
• dnf install ./package.rpm - Install local RPM with dnf
• tar -xzvf package.tar.gz - Extract tarball source

⚙️ Package Cleanup:
• apt autoclean - Remove old package files
• dnf clean all - Clean DNF cache
• yum clean all - Clean YUM cache
• snap refresh --hold - Hold snap updates
• flatpak uninstall --unused - Remove unused runtimes

💡 Package Management Tips:
• Always run update before install/upgrade
• Use apt over dpkg, dnf over rpm for dependency handling
• Check repository sources for security/stability
• Use snap/flatpak for sandboxed apps
• Regularly clean caches to save disk space

⚠️ Safety Tips:
• Verify repository sources to avoid malicious packages
• Backup /etc/apt or /etc/yum.repos.d before changes
• Test package installs in a VM or container first
• Avoid mixing package managers (e.g., apt and snap)
• Monitor package changelogs for breaking changes

[Interactive package management exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                "network" -> """
🌐 Network Basics - Configuration & Troubleshooting

Learn basic network configuration, troubleshooting, and monitoring:

🔌 Network Configuration:
• ip addr show - Display network interfaces and IPs
• ip link set eth0 up - Enable network interface
• ip link set eth0 down - Disable network interface
• ip addr add 192.168.1.100/24 dev eth0 - Assign IP address
• ip route show - Show routing table
• ip route add default via 192.168.1.1 - Set default gateway

📡 Network Status:
• nmcli device status - Show network device status
• nmcli connection show - List network connections
• nmcli con up connection_name - Activate connection
• nmcli con down connection_name - Deactivate connection
• cat /etc/resolv.conf - Show DNS servers
• hostname -i - Show host IP address

🔍 Network Troubleshooting:
• ping 8.8.8.8 - Test connectivity to Google DNS
• ping -c 4 google.com - Send 4 pings to domain
• traceroute google.com - Trace route to destination
• mtr google.com - Continuous ping and traceroute
• dig google.com - DNS lookup
• nslookup google.com - Alternative DNS lookup

🌐 Network Monitoring:
• ss -tuln - Show listening TCP/UDP ports
• netstat -tuln - Alternative to ss
• netstat -i - Show interface statistics
• ifconfig - Show interface details (older systems)
• ip -s link - Show interface statistics
• netcat -zv host port - Test port connectivity

📥 Data Transfer:
• wget http://example.com/file - Download file
• curl http://example.com - Fetch URL content
• curl -O http://example.com/file - Download with original name
• scp file.txt user@host:/path - Secure copy to remote
• rsync -av file.txt user@host:/path - Sync with remote
• ftp host - Connect to FTP server

🔧 Network Configuration Files:
• cat /etc/hosts - Local hostname mappings
• cat /etc/network/interfaces - Debian network config
• cat /etc/sysconfig/network-scripts/ifcfg-* - Red Hat network config
• nmcli con mod connection_name ipv4.addresses 192.168.1.100/24
• nmcli con mod connection_name ipv4.dns 8.8.8.8 - Set DNS

💡 Network Tips:
• Use ip instead of ifconfig (modern systems)
• Check /etc/resolv.conf for DNS issues
• Use -c with ping to limit attempts
• Combine curl/wget with pipes: curl url | grep pattern
• Test connectivity with ping before complex tasks

⚠️ Safety Tips:
• Avoid exposing unnecessary ports (check with ss)
• Use scp or rsync for secure file transfers
• Verify hostnames in /etc/hosts to avoid DNS issues
• Backup network configs before editing
• Test network changes in a safe environment

[Interactive network exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
        """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "kernel" -> """
🔧 Kernel & Modules - Low-Level System Management

Master kernel management, module development, and system customization:

📋 Kernel Information:
• uname -r - Show kernel version
• cat /proc/version - Detailed kernel information
• cat /proc/cmdline - Kernel boot parameters
• dmesg | head - Kernel boot messages
• lscpu - CPU and architecture details
• cat /proc/cpuinfo - Detailed CPU information

🔌 Module Management:
• lsmod - List loaded kernel modules
• modinfo module_name - Show module information
• modprobe module_name - Load a module with dependencies
• modprobe -r module_name - Remove module and dependencies
• rmmod module_name - Remove module (no dependency handling)
• depmod -a - Update module dependency database

🏗️ Kernel Compilation:
• make menuconfig - Configure kernel options (ncurses interface)
• make xconfig - Configure kernel options (Qt interface)
• make defconfig - Use default configuration
• make -j$(nproc) - Compile kernel using all CPU cores
• make modules - Compile kernel modules
• make modules_install - Install compiled modules
• make install - Install kernel to /boot

📦 DKMS (Dynamic Kernel Module Support):
• dkms status - Show DKMS module status
• dkms add module/version - Add module to DKMS
• dkms build module/version - Build module
• dkms install module/version - Install DKMS module
• dkms remove module/version --all - Remove module

🔧 Kernel Parameters:
• sysctl -a - Show all kernel parameters
• sysctl kernel.hostname - Show specific parameter
• sysctl -w net.ipv4.ip_forward=1 - Set parameter temporarily
• echo 'net.ipv4.ip_forward=1' >> /etc/sysctl.conf - Permanent setting
• sysctl -p - Reload sysctl configuration

💾 Memory Management:
• cat /proc/meminfo - Memory information
• cat /proc/slabinfo - Slab allocator information
• echo 3 > /proc/sys/vm/drop_caches - Drop page caches
• cat /proc/buddyinfo - Buddy allocator information
• cat /proc/pagetypeinfo - Page type information

🔍 Kernel Debugging:
• dmesg -w - Follow kernel messages in real-time
• journalctl -k - Show kernel messages from journal
• cat /proc/kallsyms - Kernel symbol table
• crash vmlinux vmcore - Kernel crash analysis
• kexec - Kernel execution for crash dumps

⚡ Real-Time Kernel:
• chrt -f -p 99 PID - Set real-time FIFO priority
• chrt -r -p 50 PID - Set real-time round-robin priority
• cat /sys/kernel/realtime - Check if RT kernel
• cyclictest - Real-time latency testing

💡 Kernel Tips:
• Use modinfo to check module parameters
• Test kernel compilation in a VM first
• Monitor dmesg for module load issues
• Use sysctl -a | grep pattern to find parameters
• Backup /boot before installing new kernels

⚠️ Safety Tips:
• Backup kernel and initramfs before compiling
• Test DKMS modules on non-critical systems
• Avoid unloading critical modules (e.g., filesystem)
• Verify sysctl changes with sysctl -a
• Use kexec for safe crash dump testing

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "network" -> """
🌐 Advanced Networking - Network Security & Configuration

Master network administration, security, and troubleshooting:

🔥 Firewall Management (iptables):
• iptables -L -v -n - List all rules with verbose output
• iptables -A INPUT -p tcp --dport 22 -j ACCEPT - Allow SSH
• iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT
• iptables -P INPUT DROP - Set default policy to drop
• iptables -F - Flush all rules (careful!)
• iptables-save > /etc/iptables/rules.v4 - Save rules

🛡️ Netfilter and nftables:
• nft list ruleset - Show all nftables rules
• nft add table inet my_table - Create new table
• nft add chain inet my_table input { type filter hook input priority 0 \; policy drop \; }
• nft add rule inet my_table input tcp dport 22 accept - Allow SSH
• nft flush ruleset - Clear all rules
• /etc/nftables.conf - Persistent nftables config

🌐 Traffic Shaping (tc):
• tc qdisc add dev eth0 root netem delay 100ms - Add 100ms delay
• tc qdisc show dev eth0 - Show queuing disciplines
• tc filter add dev eth0 protocol ip prio 1 u32 match ip dst 192.168.1.0/24 - Filter traffic
• tc qdisc del dev eth0 root - Remove traffic shaping
• tc -s qdisc show - Detailed statistics

🔒 VPN Configuration:
• openvpn --config client.ovpn - Start OpenVPN client
• wg-quick up wg0 - Start WireGuard VPN
• wg show - Show WireGuard status
• ipsec start - Start IPsec VPN
• /etc/openvpn/server.conf - OpenVPN server config
• /etc/wireguard/wg0.conf - WireGuard config

🔍 Advanced Network Monitoring:
• nmap localhost - Scan open ports
• wireshark - Graphical packet analyzer
• tcpdump -i eth0 port 80 - Capture HTTP traffic
• iftop -i eth0 - Real-time bandwidth by host
• netstat -s - Network statistics summary
• ss -s - Socket statistics

💡 Networking Tips:
• Use nftables over iptables for modern systems
• Test firewall rules in a VM or container
• Combine tc with iptables for advanced shaping
• Monitor VPN logs for connection issues
• Use Wireshark filters for targeted analysis

⚠️ Safety Tips:
• Backup firewall rules before modifying
• Test VPN configs on non-production networks
• Avoid exposing critical ports unnecessarily
• Verify tc rules with tc show
• Use nmap carefully to avoid legal issues

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "security" -> """
🔐 Security Hardening - System Security & Mitigation

Learn system security, mandatory access controls, and vulnerability mitigation:

🔒 SELinux (Security-Enhanced Linux):
• sestatus - Show SELinux status
• getenforce - Show current SELinux mode
• setenforce 0 - Set permissive mode (temporary)
• setenforce 1 - Set enforcing mode
• chcon -t type_t file - Change SELinux context
• restorecon -R /path - Restore default contexts
• /etc/selinux/config - Persistent SELinux config

🛡️ AppArmor:
• aa-status - Show AppArmor profile status
• aa-genprof program - Generate profile
• aa-enforce /usr/bin/program - Enforce profile
• aa-complain /usr/bin/program - Set complain mode
• /etc/apparmor.d/ - AppArmor profile directory
• apparmor_parser -r profile - Reload profile

📜 Audit System:
• auditctl -l - List audit rules
• auditctl -a always,exit -F arch=b64 -S open -k file_open
• ausearch -k file_open - Search audit logs
• aureport - Generate audit report
• /etc/audit/audit.rules - Persistent audit rules
• service auditd restart - Restart audit daemon

🔐 Secure Boot:
• mokutil --sb-state - Check Secure Boot status
• mokutil --import key.der - Import MOK key
• mokutil --list-enrolled - List enrolled keys
• shim-signed - UEFI shim for Secure Boot
• grub2-mkconfig - Update GRUB for Secure Boot
• /boot/efi/EFI/ - EFI system partition

🔍 Hardening Practices:
• chmod 600 /etc/ssh/sshd_config - Restrict SSH config
• ufw enable - Enable uncomplicated firewall
• fail2ban-client status - Check intrusion prevention
• lynis audit system - Run security audit
• chkrootkit - Check for rootkits
• rkhunter --check - Rootkit hunter scan

💡 Security Tips:
• Use SELinux in enforcing mode for critical systems
• Test AppArmor profiles in complain mode first
• Monitor audit logs regularly
• Enable Secure Boot for trusted boot chain
• Run lynis for baseline hardening

⚠️ Safety Tips:
• Backup SELinux/AppArmor configs
• Test audit rules in a non-production environment
• Verify Secure Boot keys before enrolling
• Avoid disabling security mechanisms
• Update system regularly: apt update && apt upgrade

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "virtual" -> """
🐳 Virtualization - Containers and Virtual Machines

Master container technologies, orchestration, and VM management:

📦 Docker Containers:
• docker run -it image - Run container interactively
• docker ps - List running containers
• docker stop container_id - Stop container
• docker rm container_id - Remove container
• docker images - List images
• docker pull image - Pull image from registry
• docker build -t myimage . - Build image from Dockerfile

🏗️ Kubernetes Orchestration:
• kubectl get pods - List pods in namespace
• kubectl apply -f deployment.yaml - Apply config
• kubectl describe pod pod_name - Show pod details
• kubectl logs pod_name - View pod logs
• kubectl exec -it pod_name -- bash - Access pod
• minikube start - Start local Kubernetes cluster

🔗 LXC Containers:
• lxc-create -n container -t download - Create container
• lxc-start -n container - Start container
• lxc-attach -n container - Access container shell
• lxc-ls -f - List containers
• lxc-stop -n container - Stop container
• /etc/lxc/lxc.conf - LXC configuration

🖥️ KVM/QEMU Virtual Machines:
• virt-install --name vm --ram 2048 --disk size=20 --os-variant ubuntu20.04
• virsh list --all - List all VMs
• virsh start vm_name - Start VM
• virsh shutdown vm_name - Shutdown VM
• virt-manager - Graphical VM manager
• qemu-system-x86_64 - Boot VM manually

🔧 Libvirt Management:
• virsh list --all - List all VMs
• virsh edit vm_name - Edit VM configuration
• virsh snapshot-create vm_name - Create VM snapshot
• virsh snapshot-revert vm_name snap - Revert to snapshot
• virsh net-list --all - List virtual networks
• /etc/libvirt/qemu/ - VM configurations

💡 Virtualization Tips:
• Use Docker for lightweight containers
• Test Kubernetes with minikube locally
• Combine LXC with LXD for management
• Use virt-manager for easy VM setup
• Monitor container/VM resource usage

⚠️ Safety Tips:
• Backup VM/container configs before changes
• Test orchestration in a sandbox
• Restrict container privileges (--cap-drop)
• Verify VM images for security
• Monitor network traffic for containers/VMs

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "ha" -> """
🏗️ High Availability - Clustering & Load Balancing

Learn clustering, load balancing, and fault-tolerant system design:

🔗 Pacemaker/Corosync:
• pcs cluster setup cluster_name node1 node2 - Create cluster
• pcs status - Show cluster status
• pcs resource create name type - Create resource
• pcs constraint colocation add r1 with r2 - Set resource colocation
• pcs resource disable name - Disable resource
• corosync-cfgtool -s - Show Corosync status

⚖️ Load Balancing (HAProxy):
• haproxy -f /etc/haproxy/haproxy.cfg - Start HAProxy
• systemctl restart haproxy - Restart service
• haproxy -c -f /etc/haproxy/haproxy.cfg - Check config
• stats socket /var/run/haproxy.sock - Admin socket
• frontend http bind *:80 - Example frontend config
• backend servers server s1 192.168.1.10:80 - Example backend

🔄 Keepalived (VRRP):
• keepalived -f /etc/keepalived/keepalived.conf - Start keepalived
• systemctl restart keepalived - Restart service
• vrrp_instance VI_1 { state MASTER; interface eth0; } - VRRP config
• ip addr show - Check virtual IP status
• /var/log/keepalived.log - Monitor logs
• unicast_peer { 192.168.1.2 } - Unicast VRRP

💾 Distributed Replicated Block Device (DRBD):
• drbdadm create-md resource - Initialize resource
• drbdadm up resource - Bring resource online
• drbdadm primary resource --force - Set primary node
• drbd-overview - Show DRBD status
• /etc/drbd.d/resource.res - DRBD configuration
• drbdadm status - Detailed status

🔍 Monitoring HA Systems:
• crm_mon -i 2 - Cluster resource monitor
• haproxy -f config.cfg -D - Monitor HAProxy
• tail -f /var/log/keepalived.log - Monitor keepalived
• drbdmon - Real-time DRBD monitor
• pcs status resources - Resource status

💡 HA Tips:
• Use Pacemaker for complex clusters
• Test HAProxy configs with -c first
• Configure keepalived for failover IPs
• Monitor DRBD sync status
• Use redundant networks for HA

⚠️ Safety Tips:
• Backup cluster configs before changes
• Test failover in a non-production setup
• Verify virtual IPs with ip addr
• Monitor logs for HA issues
• Avoid single points of failure

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "internals" -> """
🔍 System Internals - Deep Kernel & System Understanding

Dive into Linux system internals and debugging:

📂 /proc Filesystem:
• cat /proc/cpuinfo - CPU details
• cat /proc/meminfo - Memory statistics
• cat /proc/loadavg - Load averages
• cat /proc/uptime - System uptime
• cat /proc/stat - Kernel/system statistics
• cat /proc/interrupts - Interrupt statistics

📂 /sys Filesystem:
• cat /sys/kernel/debug - Debug filesystem mount point
• echo 1 > /sys/block/sda/queue/rotational - Set device properties
• cat /sys/class/net/eth0/speed - Network interface speed
• cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor - CPU governor

📡 System Calls Tracing:
• strace command - Trace system calls
• strace -p PID - Attach to running process
• strace -e open,read command - Trace specific syscalls
• strace -c command - Count and summarize syscalls
• strace -o trace.txt command - Output to file

🔧 Kernel Debugging Tools:
• gdb -p PID - Attach GDB to process
• kdump-config status - Check kdump status
• gdb vmlinux /proc/kcore - Debug running kernel
• gdb vmlinux vmcore - Kernel crash analysis
• kexec - Kernel execution for crash dumps

⚙️ Process and Thread Internals:
• cat /proc/PID/status - Process status and memory usage
• cat /proc/PID/maps - Process memory mappings
• cat /proc/PID/fd - Open file descriptors
• cat /proc/PID/task - Thread information
• pmap -x PID - Detailed process memory map
• lsof -p PID - List open files by process

📊 I/O and Scheduling:
• iostat -c - CPU statistics
• iostat -d - Device statistics
• cat /proc/sched_debug - Scheduler debug info
• chrt -r -p 50 PID - Set real-time scheduling
• taskset -cp 0-3 PID - Pin process to CPUs 0-3
• ionice -c 3 PID - Set I/O scheduling class

🔧 eBPF for Internals:
• bpftool prog list - List loaded eBPF programs
• bpftool map list - List eBPF maps
• bcc-tools (e.g., execsnoop) - Trace process execution
• bcc-tools (e.g., opensnoop) - Trace file opens
• bpftrace -e 'kprobe:do_sys_open { printf("%s opened %s\n", comm, str(arg1)); }'

💡 Internals Tips:
• Use /proc for runtime system information
• Be cautious when writing to /sys or /proc
• strace/ltrace for debugging application issues
• Use crash or gdb for kernel crash analysis
• eBPF requires modern kernels (4.1+)

⚠️ Safety Tips:
• Avoid modifying /proc or /sys without understanding
• Test kernel debugging in a VM or non-production system
• Backup crash dumps before analysis
• Ensure kdump is configured for crash recovery
• Monitor system stability after changing scheduling

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                "performance" -> """
⚡ Performance Tuning - System Optimization & Profiling

Master system optimization and advanced performance analysis:

📊 Performance Profiling with perf:
• perf stat command - Collect performance statistics
• perf record -p PID - Record performance data
• perf report - Analyze recorded data
• perf top - Real-time system profiling
• perf record -g command - Include call graphs
• perf annotate function_name - View annotated assembly

🔍 System Call Tracing:
• strace -t -p PID - Trace system calls with timestamps
• strace -c command - Summarize system call counts
• sysdig -c topcalls - System-wide syscall statistics
• strace -e openat,read command - Trace specific syscalls
• bpftrace -e 'tracepoint:syscalls:sys_enter_openat { @count++ }'

📚 Library Call Tracing:
• ltrace -c command - Summarize library calls
• ltrace -S command - Include system calls
• ltrace -o trace.txt command - Output to file
• ltrace -f command - Trace child processes
• ltrace -e malloc,free command - Trace specific calls

🔧 Memory Profiling with valgrind:
• valgrind --tool=memcheck command - Check memory leaks
• valgrind --tool=massif command - Profile heap usage
• valgrind --tool=cachegrind command - Cache performance
• valgrind --leak-check=full command - Detailed leak check
• massif-visualizer massif.out.* - Visualize heap data

⚙️ SystemTap Profiling:
• stap -v script.stp - Run SystemTap script
• stap -e 'probe kernel.function("do_sys_open") { println(execname(), " opened ", user_string($\filename)) }'
• stap --example cpu.stp - Example CPU probe
• staprun -L - List available probes
• stap -o output.txt script.stp - Output to file

📈 eBPF Performance Tools:
• bpftool prog show - Show loaded eBPF programs
• bcc-tools/biosnoop - Trace block I/O latency
• bcc-tools/execsnoop - Trace new process execution
• bcc-tools/opensnoop - Trace file opens
• bpftrace -e 'kprobe:do_sys_open { @opens[comm] = count(); }' - Count opens

🔍 CPU and Scheduling Tuning:
• taskset -c 0-3 command - Pin to specific CPUs
• chrt -r -p 50 PID - Set real-time priority
• cpupower frequency-set -g performance - Set CPU governor
• cat /proc/cpuinfo - Check CPU capabilities
• tuned-adm profile throughput-performance - Set tuned profile

💾 Memory Tuning:
• sysctl vm.swappiness=10 - Adjust swap usage
• sysctl vm.dirty_ratio=20 - Control dirty page flush
• echo 3 > /proc/sys/vm/drop_caches - Clear caches
• vmstat -SM - Memory stats in MB
• free -m - Memory usage summary

💿 I/O Tuning:
• ionice -c 2 -n 4 command - Set I/O priority
• echo deadline > /sys/block/sda/queue/scheduler - Set I/O scheduler
• iostat -x 1 - Extended I/O statistics
• hdparm -tT /dev/sda - Disk performance test
• fio --name=test --filename=/dev/sda --rw=read - I/O benchmark

🌐 Network Tuning:
• sysctl net.core.somaxconn=1024 - Increase socket backlog
• sysctl net.ipv4.tcp_max_syn_backlog=4096 - TCP backlog
• ethtool -G eth0 rx 4096 tx 4096 - Adjust ring buffers
• ethtool -K eth0 tso off gso off - Disable offloading
• sysctl net.ipv4.tcp_congestion_control=bbr - Set BBR

💡 Performance Tips:
• Use perf for high-level profiling
• Combine strace and perf for detailed insights
• Test tuning in a non-production environment
• Monitor with top, htop, or glances during tuning
• Save profiles for reproducible results

⚠️ Safety Tips:
• Backup sysctl.conf before modifying
• Test performance changes incrementally
• Avoid aggressive tuning on production systems
• Monitor system stability after changes
• Use VMs or containers for experiments

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
        """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}